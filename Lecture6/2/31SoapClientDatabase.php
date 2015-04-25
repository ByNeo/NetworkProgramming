<?php
/**
 * Created by PhpStorm.
 * User: wsan
 * Date: 21.01.2015
 * Time: 23:17
 */

$options = array(
    'uri' => 'http://server/namespace',
    'location' => 'http://localhost/NetworkProgramming/Lecture6/1/32SoapServerDatabase.php',
);
$client = new SOAPClient(null, $options);
echo $client->select(19, 10);

//var_dump( $client->add(15, 10));