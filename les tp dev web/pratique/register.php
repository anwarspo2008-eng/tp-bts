<?php
$pdo = new PDO("mysql:host=127.0.0.1;port=3308;dbname=testdb;charset=utf8mb4", "root", "");
$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

$full_name = trim($_POST["full_name"]);
$phone     = trim($_POST["phone"]);
$email     = trim($_POST["email"]);
$password  = $_POST["password"];

$hash = password_hash($password, PASSWORD_DEFAULT);

try {
    $stmt = $pdo->prepare(
        "INSERT INTO users (full_name, phone, email, password) VALUES (?, ?, ?, ?)"
    );
    $stmt->execute([$full_name, $phone, $email, $hash]);
    echo "Account created. <a href='index.html'>Go to login</a>";
} catch (PDOException $e) {
    echo "This email is already used. <a href='register.html'>Try again</a>";
}