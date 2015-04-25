<?php
/**
 * Created by PhpStorm.
 * User: wsan
 * Date: 11.01.2015
 * Time: 01:56
 */
print("Veritabanı Bağlantısı Test...deneme");
$connectionID=pg_connect("host=localhost dbname=OrcaDatabase user=CourseUser password=CoursePassword")
or die("Can't connect to database".pg_last_error());
pg_close($connectionID);

$connectionID=pg_connect("host=localhost dbname=pagila user=postgres password=postgres")
or die("Can't connect to database".pg_last_error());
$query = "SELECT * FROM customer  LIMIT 50";

$rs = pg_query($connectionID, $query) or die("Cannot execute query: $query\n");



while ($row = pg_fetch_row($rs)) {
    echo "$row[0] $row[1] $row[2]\n<br/>";
}
pg_close($connectionID);
