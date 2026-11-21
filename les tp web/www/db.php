<?php
$pdo = new PDO("mysql:host=127.0.0.1;port=3308;dbname=testdb;charset=utf8mb4", "root", "");
$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

$pdo->exec("CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(190) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
) ENGINE=InnoDB");

$pdo->exec("CREATE TABLE IF NOT EXISTS stagiaires (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    filiere VARCHAR(100) NOT NULL
) ENGINE=InnoDB");

$pdo->exec("CREATE TABLE IF NOT EXISTS notes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    stagiaire_id INT NOT NULL,
    matiere VARCHAR(100) NOT NULL,
    note DECIMAL(4,2) NOT NULL,
    FOREIGN KEY (stagiaire_id) REFERENCES stagiaires(id) ON DELETE CASCADE
) ENGINE=InnoDB");

function e($text) {
    return htmlspecialchars($text, ENT_QUOTES, "UTF-8");
}