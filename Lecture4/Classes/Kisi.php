<?php



/**
 * 
 */
 
class Kisi
{

    /**
     * @var string
     */
    private $ad;
    /**
     * @var string
     */
    private $soyad;

    /**
     * @param string $ad
     */
    public function setAd($ad)
    {
        $this->ad = $ad;
    }

    /**
     * @return string
     */
    public function getAd()
    {
        return $this->ad;
    }

    /**
     * @param string $soyad
     */
    public function setSoyad($soyad)
    {
        $this->soyad = $soyad;
    }

    /**
     * @return string
     */
    public function getSoyad()
    {
        return $this->soyad;
    }

    /**
     * fonksiyonlar aşırı yüklenemez...
     */
    function __construct()
	{
		$this->ad="";
		$this->soyad="";
	}

    /**
     * @return string
     */

    public function kisiListele()
    {
        //echo "$this->ad.$this->soyad";

        return "$this->ad"."$this->soyad";
    }
    public function setKisiBilgileri($ad,$soyad)
    {
        $this->ad=$ad;
        $this->soyad=$soyad;

    }

}



?>

