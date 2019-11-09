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
        System.out.print("A fizetendő összeg: ");
        int amount = scan.nextInt();
        System.out.print("A fizetett összeg: ");
        int paid = scan.nextInt();
/*
       int paid = 100000;
       int amount = 15000;
*/
        System.out.println("A visszajáró összeg: " + moneyBack(amount, paid));
    }
    catch (Exception e){
        System.err.println("Hiba történt! Egész számot adjon meg! Az második érteknek >= kell lenie az első értékkel.");
    }
    }
    public static int differencE(int amount, int paid){
        return (paid-amount);
    }

    public static int roundDifference(int amount, int paid){
        int difference = paid - amount;
        switch (difference % 10 ) {
            case 2:
            case 7: return difference-2;
            case 1:
            case 6: return difference-1;
            case 4:
            case 9: return difference+1;
            case 3:
            case 8: return difference+2;
        }
     return difference;
    }


    public static StringBuilder moneyBack(int amount, int paid){
        int [] denominations = {20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 10, 5};
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();

        int difference = roundDifference(amount, paid);
        if (difference == 0){
            return stringBuilder1.append("Nincs visszajáró!");
        }

        stringBuilder1.append(differencE(amount,paid) + " Ft => " + difference + " = ");

        for(int i=0; i<denominations.length; i++){
            if(difference > denominations[i] ||  difference == denominations[i]){
               int div = difference / denominations[i];
               difference = difference - div * denominations[i];
               stringBuilder2.append(div +"*"+denominations[i]+"Ft + " );
            }
         }
        stringBuilder2.delete(stringBuilder2.length()-2, stringBuilder2.length());
        stringBuilder1.append(stringBuilder2);
        return stringBuilder1;
    }
}
