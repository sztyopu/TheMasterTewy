package com.company;

import java.util.Scanner;

public class Main {
/*
Készitsen egy olyan modult amely egy rendszer részeként visszajáró összeget számol a lehető legkevesebb darabszámú
pénjegy és érme (magyar forint) felhasználásával. A bemenő paraméterek a fizetendő és a fizetett összeg.
Figyeljen, hogy a lehető legteljesebb megoldást adja!
*/
    public static void main(String[] args) {
    try{
        Scanner scan = new Scanner(System.in);
        System.out.print("The amount due: ");
        int amount = scan.nextInt();
        System.out.print("The amount paid: ");
        int paid = scan.nextInt();
/*
       int paid = 100000;
       int amount = 15000;
*/
        System.out.println("Your change is: " + (paid-amount) + " Ft = " + moneyBack(amount, paid));
    }
    catch (Exception e){
        System.err.println("A formátum nem megfelelő! Csak egész számot adhat meg!");
    }
    }

    public static StringBuilder moneyBack(int amount, int paid){
        int [] denominations = {20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 10, 5};
        StringBuilder stringBuilder = new StringBuilder();

        int difference = paid - amount;

        for(int i=0; i<denominations.length; i++){
            if(difference > denominations[i] ||  difference == denominations[i]){
               int maradek = difference / denominations[i];
               stringBuilder.append(maradek +"*"+denominations[i]+"Ft + " );
               difference = difference - maradek * denominations[i];
            }
         }
        stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
        return stringBuilder;
    }
}
