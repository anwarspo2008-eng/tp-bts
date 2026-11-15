<?php
require "auth.php";

$id = (int)($_GET["id"] ?? 0);

$stmt = $pdo->prepare("SELECT * FROM stagiaires WHERE id = ?");
$stmt->execute([$id]);
$s = $stmt->fetch(PDO::FETCH_ASSOC);

if (!$s) {
    header("Location: home.php");
    exit;
}

if ($_SERVER["REQUEST_METHOD"] === "POST") {

    if (isset($_POST["add"])) {
        $matiere = trim($_POST["matiere"]);
        $note    = str_replace(",", ".", trim($_POST["note"]));

        if ($matiere !== "" && is_numeric($note) && $note >= 0 && $note <= 20) {
            $stmt = $pdo->prepare("INSERT INTO notes (stagiaire_id, matiere, note) VALUES (?, ?, ?)");
            $stmt->execute([$id, $matiere, $note]);
        }
    }

    if (isset($_POST["delete"])) {
        $stmt = $pdo->prepare("DELETE FROM notes WHERE id = ? AND stagiaire_id = ?");
        $stmt->execute([$_POST["note_id"], $id]);
    }

    header("Location: student.php?id=" . $id);
    exit;
}

$stmt = $pdo->prepare("SELECT id, matiere, note FROM notes WHERE stagiaire_id = ? ORDER BY id");
$stmt->execute([$id]);
$notes = $stmt->fetchAll(PDO::FETCH_ASSOC);

$values  = array_map("floatval", array_column($notes, "note"));
$moyenne = count($values) > 0 ? array_sum($values) / count($values) : null;
$labels  = array_column($notes, "matiere");
$colors  = array_map(fn($v) => $v < 10 ? "#e8573a" : "#f5c84c", $values);
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><?= e($s["nom"]) ?></title>
    <link rel="stylesheet" href="app.css">
</head>
<body>
<div class="wrap">

    <div class="topbar">
        <h1><?= e($s["nom"] . " " . $s["prenom"]) ?></h1>
        <a class="btn light small" href="home.php">&larr; Back</a>
    </div>

    <div class="panel">
        <h2>Add a grade</h2>
        <form method="post" class="add-form">
            <label>Subject <input type="text" name="matiere" required></label>
            <label>Grade /20 <input type="number" name="note" min="0" max="20" step="0.25" required></label>
            <button class="btn" type="submit" name="add">Add</button>
        </form>
    </div>

    <div class="panel">
        <h2>Grades - <?= e($s["filiere"]) ?></h2>

        <?php if (count($notes) === 0): ?>
            <p class="empty">No grades yet.</p>
        <?php else: ?>
            <div class="table-scroll">
                <table>
                    <tr><th>Subject</th><th>Grade</th><th></th></tr>
                    <?php foreach ($notes as $n): ?>
                        <tr>
                            <td><?= e($n["matiere"]) ?></td>
                            <td class="<?= $n["note"] < 10 ? "low" : "" ?>"><?= number_format($n["note"], 2) ?></td>
                            <td>
                                <form method="post">
                                    <input type="hidden" name="note_id" value="<?= $n["id"] ?>">
                                    <button class="btn small" type="submit" name="delete">Delete</button>
                                </form>
                            </td>
                        </tr>
                    <?php endforeach; ?>
                </table>
            </div>
            <p class="avg">Average: <?= number_format($moyenne, 2) ?> / 20</p>
        <?php endif; ?>
    </div>

    <?php if (count($notes) > 0): ?>
        <div class="panel">
            <h2>Chart</h2>
            <canvas id="gradesChart"></canvas>
        </div>
    <?php endif; ?>

</div>

<?php if (count($notes) > 0): ?>
<script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.1/dist/chart.umd.min.js"></script>
<script>
Chart.defaults.font.family = "'Space Mono', 'Courier New', monospace";
Chart.defaults.color = "#1b1a17";

new Chart(document.getElementById("gradesChart"), {
    type: "bar",
    data: {
        labels: <?= json_encode($labels, JSON_HEX_TAG) ?>,
        datasets: [{
            label: "Grade /20",
            data: <?= json_encode($values) ?>,
            backgroundColor: <?= json_encode($colors) ?>,
            borderColor: "#1b1a17",
            borderWidth: 3
        }]
    },
    options: {
        plugins: { legend: { display: false } },
        scales: { y: { min: 0, max: 20 } }
    }
});
</script>
<?php endif; ?>
</body>
</html>