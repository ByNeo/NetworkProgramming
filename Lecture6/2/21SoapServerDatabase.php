<?php
/**
 * Created by PhpStorm.
 * User: wsan
 * Date: 21.01.2015
 * Time: 23:14
 */


//Otamatik WSDL oluşturma aracı nusoap kullanımı

require_once('References/nusoap-0.9.5/lib/nusoap.php');


class DBService
{
    public function select($x)
    {
        $connectionID=pg_connect("host=localhost dbname=pagila user=LectureUser password=LecturePassword")
        or die("Can't connect to database".pg_last_error());
        $query = "SELECT * FROM customer where customer_id=$x";

        $rs = pg_query($connectionID, $query) or die("Cannot execute query: $query\n");

        $row = pg_fetch_row($rs);


        return $row[0].$row[1].$row[2].$row[3].$row[4].$row[5].$row[6].$row[7];

    }
}


$server = new soap_server();

$server->configureWSDL("CustomerService", "http://localhost/NetworkProgramming/Lecture6/2/CustomerService");

$server->register("DBService.select",
    array("type" => "xsd:int"),
    array("return" => "xsd:string"),
    "http://localhost/NetworkProgramming/Lecture6/2/CustomerService",
    "http://localhost/NetworkProgramming/Lecture6/2/CustomerService#select",
    "rpc",
    "encoded",
    "Return customer by id");

@$server->service($HTTP_RAW_POST_DATA);