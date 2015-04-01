
<?php

require_once 'Include/DatabaseConnection.php';
require_once 'Classes/ClassSessionManagement.php';
//require_once 'Classes/ClassNesneOlusturucu.php';

// require_once 'Guvenlik/PersonelDenetim.php';

//$sql="SELECT personelNo,sifre FROM personel where personelNo='".$_POST['personelNo']."' AND sifre='".md5($_POST['sifre'])."'";
//$sql="SELECT personelNo,sifre FROM personel where personelNo='".$_POST['personelNo']."' AND sifre='".$_POST['sifre']."'";
//md5() 128 bitlik şifrelenmiş hash üretir
// $hash = hash('sha256', $pass); 256 bitlik şifrelenmiş hash üretir

//$result = $veritabani->query($sql);

//$kisi1=NesneOlusturucu::nesneOlustur('Kisi');

$userService = new SessionManagement($veritabani, $_POST['personelNo'], $_POST['sifre']);

if ($user=$userService->login())
{

    session_start();

    $_SESSION['personelNo'] = $_POST['personelNo'];

    $_SESSION['baglandi'] =TRUE;

    $_SESSION['baslangicZamani']=time();
    $_SESSION['user']=$user;

    // Yetki düzeyi de eklenmeli...

    $data= array ('sonuc'=>'1');
    //print_r($data);
}
else
{
    $data= array ('sonuc'=>'0');
    //print_r($data);

}

echo json_encode($data);
//  JavaScript Object Notation yalnızca veri alış-verişi amacıyla oluşturulmuş bir veri biçimlendirme yöntemidir
// XML e göre daha az yer kaplar. json verilerini java script ile erişmek XML e (parsing is necessary)
// göre çok daha kolaydır.
// $.getJSON(), ve $.ajax({ dataType: 'json'}) fonksiyonlarıyla verilere erişilebilir.
