<?php
session_start();

$pdo = new PDO("mysql:host=127.0.0.1;port=3308;dbname=testdb;charset=utf8mb4", "root", "");
$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

$email    = trim($_POST["email"]);
$password = $_POST["password"];

$stmt = $pdo->prepare("SELECT id, full_name, password FROM users WHERE email = ?");
$stmt->execute([$email]);
$user = $stmt->fetch(PDO::FETCH_ASSOC);

if ($user && password_verify($password, $user["password"])) {
    $_SESSION["user_id"]   = $user["id"];
    $_SESSION["full_name"] = $user["full_name"];
    header("Location: home.php");
    exit;
}

echo "Wrong email or password. <a href='index.html'>Try again</a>";