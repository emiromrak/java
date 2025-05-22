package com.mycompany.basit_atm_programi;

import java.util.Scanner;

public class atm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** ATM'ye Hos Geldiniz! ***");
        System.out.println("Lutfen bakiyenizi giriniz.");       
        int bakiye=scanner.nextInt();
        islemler atm = new islemler(0, 0, bakiye);
              
        atm.islem();       
    }
}
