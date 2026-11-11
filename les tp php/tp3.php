<?php
$a = 10;
$b = 7;
$c = 9;

$moyenne = ($a + $b + $c) / 3;
if ($moyenne >= 10) {
    echo "La moyenne est de $moyenne, vous avez admis.<br>";
} elseif ($moyenne >= 9) {
    echo "La moyenne est de $moyenne, vous avez le rattrapage.<br>";
} else {
    echo "La moyenne est de $moyenne, vous avez ajourné.<br>";
}
?>