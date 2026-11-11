<?php 
$a = 20;
$b = 20;
$c = 20;

$moyenne = ($a + $b + $c) / 3;
switch ($moyenne) {
    case ($moyenne < 10):
        echo "La moyenne est de $moyenne, vous avez ajourné .<br>";
        break;
    case ($moyenne <= 12):
        echo "La moyenne est de $moyenne, vous avez admis avec passable .<br>";
        break;
    case ($moyenne <= 14):
        echo "La moyenne est de $moyenne, vous avez admis avec  bien .<br>";
        break;
    case ($moyenne <= 16):
        echo "La moyenne est de $moyenne, vous avez admis avec tres bien .<br>";
        break;
    case ($moyenne <= 18):
        echo "La moyenne est de $moyenne, vous avez admis avec excellent .<br>";
        break;
    case ($moyenne <= 20):
        echo "La moyenne est de $moyenne, vous avez admis avec felicitation du jury .<br>";
        break;
    default:
        echo "are u sure nigga ?<br>";
        break;

}
?>