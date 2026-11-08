<?php
$a = array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

echo "<br> afichage de l'array a  avec for <br>";

for ($i = 0; $i < count($a); $i++) {
    echo $a[$i] . '&nbsp;' . "<br>";
} 
echo "<br> afichage de l'array a  avec while <br>";
$i = 0;
while ($i < count($a)) {
    echo $a[$i] . '&nbsp;' . "<br>";
    $i++;
}
echo "<br> afichage de l'array a  avec while-do <br>";
$i = 0;
do {
    echo $a[$i] . '&nbsp;' . "<br>";
    $i++;
} while ($i < count($a));

echo "<br> hashtables <br>";
$hash = array("nom" => "Doe", "prenom" => "John", "age" => 30, "ville" => "Paris");
print_r($hash );
$pos = array("zero" => 0);
print_r($pos );

echo "<br> afichage de l'array hash  avec foreach <br>";
foreach ($hash as $key => $value) {
    echo "$key : $value <br>";
}
?>
