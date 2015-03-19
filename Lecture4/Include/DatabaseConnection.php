<?php
/**
 * Created by PhpStorm.
 * User: wsan
 * Date: 15.03.2015
 * Time: 02:08
 */


	require_once 'Classes/ClassVeritabaniMysqli.php';
	require_once 'Classes/ClassIstisnaVeritabani.php';

	try
    {
        $veritabaniNesnesi= Veritabani::getInstance();
        //$veritabani = new Veritabani();
    }
    catch (DBException $e)
    {
        echo $e -> hataGoruntule();
        exit(1);
    }

    $veritabani=$veritabaniNesnesi->getVeritabani();


