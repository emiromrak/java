package com.mycompany.mavenproject4;

public class calisanlar {
    
    private String isim;
    private int seviye;
    private String departman;
    private int maas;
    
    
    public calisanlar(String isim,int seviye,String departman,int maas)
    {
        this.isim=isim;
        this.seviye=seviye;
        this.departman=departman;
        this.maas=maas;
    }
    
    public void setisim(String isim)
    {
        this.isim=isim;
    }
    
    public String getisim()
    {
        return isim;
    }

    /**
     * @return the seviye
     */
    public int getSeviye() {
        return seviye;
    }

    /**
     * @param seviye the seviye to set
     */
    public void setSeviye(int seviye) {
        this.seviye = seviye;
    }

    /**
     * @return the departman
     */
    public String getDepartman() {
        return departman;
    }

    /**
     * @param departman the departman to set
     */
    public void setDepartman(String departman) {
        this.departman = departman;
    }

    /**
     * @return the maas
     */
    public int getMaas() {
        return maas;
    }

    /**
     * @param maas the maas to set
     */
    public void setMaas(int maas) {
        this.maas = maas;
    }
    
    public void zam(int zam)
    {
        System.out.println("Calisanlara "+zam+" TL zam yapiliyor.\nYeni maas:"+(zam+getMaas())+" TL.");
    }
    
    public void bilgiler()
    {
        System.out.println("Isim: "+getisim());
        System.out.println("Departman: "+getDepartman());
        System.out.println("seviye: "+getSeviye());
        System.out.println("Maasi: "+getMaas()+" TL");
    }
    
    
    
    
    
    
}




