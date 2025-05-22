package com.mycompany.mavenproject4;

public class yazilimcilar extends calisanlar{
    
    private String dil;
    
    
    
    public yazilimcilar(String isim,int seviye,String departman,int maas,String dil)
    {
        super(isim, seviye, departman, maas);
        this.dil=dil;
    }
    
    public void setDil(String dil)
    {
        this.dil=dil;
    }
    
    public String getDil()
    {
        return dil;
    }
    
    
   
    public void bilgiler()
    {
        System.out.println("Isim: "+getisim());
        System.out.println("Departman: "+getDepartman());
        System.out.println("seviye: "+getSeviye());
        System.out.println("Dil: "+getDil());
        System.out.println("Maasi: "+getMaas()+" TL");
    } 
}
