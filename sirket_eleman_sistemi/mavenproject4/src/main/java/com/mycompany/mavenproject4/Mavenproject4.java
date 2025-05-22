package com.mycompany.mavenproject4;
public class Mavenproject4 {

    public static void main(String[] args) {

        yazilimcilar Emir = new yazilimcilar("Emir", 3, "Yazilim", 55000, "Java");
        calisanlar Sedat = new calisanlar("Sedat", 2, "Sekreter", 200);
        
        Sedat.bilgiler();
        Sedat.zam(10000);
        System.out.println("**********");
        Emir.bilgiler();
    }
}
