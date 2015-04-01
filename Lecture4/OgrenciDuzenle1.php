<?php
require_once 'Guvenlik/PersonelDenetim.php';


require_once 'Include/VeritabaniBaglantisi.php';
// 		

		$sql="Update Ogrenciler
		set adi='$_POST[adi]'

		where ogrenciNo='$_POST[ogrenciNo]'";
// 			 
		$result = mysqli_real_query($baglantiNo,$sql);
// 		
		mysqli_close($baglantiNo);

		// //$data=array();
		if($result)
		{
			
			$data= array ('sonuc'=>'1');
			//print_r($data);	
		}
		else 
		{
			$data= array ('sonuc'=>'0');
			//print_r($data);
			
		}
		//$data= array ('sonuc'=>'1');
		echo json_encode($data);
?>
