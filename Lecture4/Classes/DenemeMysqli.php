<?php
	require_once 'ClassVeritabaniMysqli.php';
	require_once 'ClassIstisnaVeritabani.php';

	try
	{
        $veritabani= Veritabani::getInstance();
		//$veritabani = new Veritabani();
	}
	catch (DBException $e)
	{
		echo $e -> hataGoruntule();
		exit(1);
	}
//$veritabani1=new Veritabani();

$veritabani1= Veritabani::getInstance();


print_r( $veritabani->getBaglantiNo());
print_r( $veritabani1->getBaglantiNo());
	try
	{
		$kosul = mysqli_real_escape_string($veritabani -> getBaglantiNo(), "A");
		//echo $kosul;
		$data = $veritabani -> select("ogrenciNo", "ogrenciler", "adi Like '$kosul%'");

		//echo mysqli_num_rows($data);
		//echo "--";
		echo $veritabani -> kayitSayisi("ogrenciNo", "ogrenciler", "adi Like'$kosul%'");
		

		$alanlarDegerler = array("telefonNo" => "'555'", "eposta" => "'xy@email.com'");

		//print_r($alanlarDegerler);
		$veritabani -> update($alanlarDegerler, "ogrenciler", "ogrenciNo = '00000000001'");
		
		
		$alanlarDegerler = array("ogrenciNo" => "'00000001117'", "adi" => "'xy'", "soyadi" => "'xy'", "sifre" => "'xy'",
		 "telefonNo" => "'xy'", "eposta" => "'xy'");
		//print_r($alanlarDegerler);
		
		//$veritabani -> insert("ogrenciler",$alanlarDegerler);
		
		
		
		$kosul = mysqli_real_escape_string($veritabani -> getBaglantiNo(), "00000001111");
		//echo $kosul;
		$data = $veritabani -> delete("ogrenciler", "ogrenciNo ='$kosul'");

	}
	catch (Exception $e)
	{
		//echo "Hata.... Sonra yeniden deneyiniz...";
		echo $e -> getMessage();
	}
	
	catch (DBException $e)
	{
		echo $e -> hataGoruntule();
	}
?>