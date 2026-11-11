<?php
$a = 20;
$i = 0;
echo "while loop <br>";

while($i <= $a) {
    echo $i . "<br>";
    $i++;
}

echo "for loop <br>";
for($i = 0; $i <= $a; $i++) {
    echo $i . "<br>";
}
echo "do while loop <br>";
$i = 0;
do {
    echo $i . "<br>";
    $i++;
} while($i <= $a);