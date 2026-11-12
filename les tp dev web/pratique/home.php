<?php
require "auth.php";

if ($_SERVER["REQUEST_METHOD"] === "POST") {

    if (isset($_POST["add"])) {
        $nom     = trim($_POST["nom"]);
        $prenom  = trim($_POST["prenom"]);
        $filiere = trim($_POST["filiere"]);

        if ($nom !== "" && $prenom !== "" && $filiere !== "") {
            $stmt = $pdo->prepare("INSERT INTO stagiaires (nom, prenom, filiere) VALUES (?, ?, ?)");
            $stmt->execute([$nom, $prenom, $filiere]);
        }
    }

    if (isset($_POST["delete"])) {
        $stmt = $pdo->prepare("DELETE FROM stagiaires WHERE id = ?");
        $stmt->execute([$_POST["id"]]);
    }

    header("Location: home.php");
    exit;
}

$stagiaires = $pdo->query(
    "SELECT s.id, s.nom, s.prenom, s.filiere,
            COUNT(n.id) AS nb_notes, AVG(n.note) AS moyenne
     FROM stagiaires s
     LEFT JOIN notes n ON n.stagiaire_id = s.id
     GROUP BY s.id
     ORDER BY s.nom"
)->fetchAll(PDO::FETCH_ASSOC);

$labels   = array_map(fn($s) => $s["nom"] . " " . $s["prenom"], $stagiaires);
$averages = array_map(fn($s) => $s["moyenne"] === null ? null : round($s["moyenne"], 2), $stagiaires);
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Stagiaires</title>
    <link rel="stylesheet" href="app.css">
</head>
<body>
<div class="wrap">

    <div class="topbar">
        <h1>Stagiaires</h1>
        <div>
            <span>Hi, <?= e($_SESSION["full_name"]) ?></span>
            <a class="btn light small" href="logout.php">Logout</a>
        </div>
    </div>

    <div class="panel">
        <h2>Add a student</h2>
        <form method="post" class="add-form">
            <label>Last name <input type="text" name="nom" required></label>
            <label>First name <input type="text" name="prenom" required></label>
            <label>Filiere <input type="text" name="filiere" required></label>
            <button class="btn" type="submit" name="add">Add</button>
        </form>
    </div>

    <div class="panel">
        <h2>All students (<?= count($stagiaires) ?>)</h2>

        <?php if (count($stagiaires) === 0): ?>
            <p class="empty">No students yet. Add the first one above.</p>
        <?php else: ?>
            <div class="table-scroll">
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Filiere</th>
                        <th>Grades</th>
                        <th>Average</th>
                        <th></th>
                    </tr>
                    <?php foreach ($stagiaires as $s): ?>
                        <tr>
                            <td>
                                <a href="student.php?id=<?= $s["id"] ?>">
                                    <?= e($s["nom"] . " " . $s["prenom"]) ?>
                                </a>
                            </td>
                            <td><?= e($s["filiere"]) ?></td>
                            <td><?= $s["nb_notes"] ?></td>
                            <td><?= $s["moyenne"] === null ? "-" : number_format($s["moyenne"], 2) ?></td>
                            <td>
                                <form method="post" onsubmit="return confirm('Delete this student and all their grades?')">
                                    <input type="hidden" name="id" value="<?= $s["id"] ?>">
                                    <button class="btn small" type="submit" name="delete">Delete</button>
                                </form>
                            </td>
                        </tr>
                    <?php endforeach; ?>
                </table>
            </div>
        <?php endif; ?>
    </div>

    <?php if (count($stagiaires) > 0): ?>
        <div class="panel">
            <h2>Averages</h2>
            <canvas id="avgChart"></canvas>
        </div>
    <?php endif; ?>

</div>

<?php if (count($stagiaires) > 0): ?>
<script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.1/dist/chart.umd.min.js"></script>
<script>
Chart.defaults.font.family = "'Space Mono', 'Courier New', monospace";
Chart.defaults.color = "#1b1a17";

new Chart(document.getElementById("avgChart"), {
    type: "bar",
    data: {
        labels: <?= json_encode($labels, JSON_HEX_TAG) ?>,
        datasets: [{
            label: "Average /20",
            data: <?= json_encode($averages) ?>,
            backgroundColor: "#e8573a",
            borderColor: "#1b1a17",
            borderWidth: 3
        }]
    },
    options: {
        scales: { y: { min: 0, max: 20 } }
    }
});
</script>
<?php endif; ?>
</body>
</html>