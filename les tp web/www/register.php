<?php
require "db.php";

$full_name = trim($_POST["full_name"] ?? "");
$phone     = trim($_POST["phone"] ?? "");
$email     = trim($_POST["email"] ?? "");
$password  = $_POST["password"] ?? "";

if ($full_name === "" || $phone === "" || $email === "" || strlen($password) < 6) {
    echo "Please fill every field (password: 6 characters minimum). <a href='register.html'>Back</a>";
    exit;
}

$hash = password_hash($password, PASSWORD_DEFAULT);

try {
    $stmt = $pdo->prepare(
        "INSERT INTO users (full_name, phone, email, password) VALUES (?, ?, ?, ?)"
    );
    $stmt->execute([$full_name, $phone, $email, $hash]);
    echo "Account created. <a href='index.html'>Go to login</a>";
} catch (PDOException $e) {
    if ($e->getCode() == 23000) {
        echo "This email is already used. <a href='register.html'>Try again</a>";
    } else {
        throw $e;
    }
}