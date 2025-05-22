package com.mycompany.basit_atm_programi;

import java.util.Scanner;

public class islemler {
    Scanner scanner = new Scanner(System.in);
    
    private int paracekme;
    private int parayatirma;
    private int bakiye;
    
    public islemler(int paracekme,int parayatirma,int bakiye)
    {
        this.paracekme=paracekme;
        this.parayatirma=parayatirma;
        this.bakiye=bakiye;
    }
    
    public void setParacekme(int paracekme)
    {
        this.paracekme=paracekme;
    }
    
    public int getParacekme()
    {
        return paracekme;
    }

    /**
     * @return the parayatirma
     */
    public int getParayatirma() {
        return parayatirma;
    }

    /**
     * @param parayatirma the parayatirma to set
     */
    public void setParayatirma(int parayatirma) {
        this.parayatirma = parayatirma;
    }

    /**
     * @return the bakiye
     */
    public int getBakiye() {
        return bakiye;
    }

    /**
     * @param bakiye the bakiye to set
     */
    public void setBakiye(int bakiye) {
        this.bakiye = bakiye;
    }
    
    
    public int bakiye(int bakiye)
    {
        return bakiye;
    }
    
    public void paracekme(int paracekme)
    {
        System.out.println("Ne kadar para cekmek istiyorsunuz?");
        int tutar=scanner.nextInt();
        
        if(tutar>bakiye)
        {
          System.out.println("Cekmek istediginiz tutar bakiyenizden fazla olamaz!\nBakiyeniz: "+bakiye);
        }
        else{
        System.out.println("Hesabinizdan "+tutar+"TL para cekilmistir.");
        bakiye-=tutar;
        System.out.println("Yeni bakiyeniz: "+bakiye);
        }
    }
    
    public void parayatirma(int parayatirma)
    {
        System.out.println("Ne kadar para yatirmak istiyorsunuz?");
        int tutar=scanner.nextInt();
        System.out.println("Hesabiniza "+tutar+"TL para yatirilmistir.");
        bakiye+=tutar;
        System.out.println("Yeni bakiyeniz: "+bakiye);
    }
    
    public void islem()
    {
        System.out.println("Hangi islemi yapmak istiyorsunuz?\n1-Bakiye Ogrenme\n2-Para Cekme\n3-Para Yatirma");
        String islemler=scanner.nextLine();
        
        switch (islemler) {
            case "1": System.out.println("Bakiyeniz: "+bakiye(bakiye));
                
                break;
                
            case "2": paracekme(paracekme);
                
                break;
                
            case "3": parayatirma(parayatirma);
                
                break;
            default:
                System.out.println("Gecersiz islem girdiniz!");
                break;
        }
    }
    
    
    
}
