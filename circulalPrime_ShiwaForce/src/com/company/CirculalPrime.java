package com.company;

public class CirculalPrime {
/*
Kerek prím keresés. Kerek primnek nevezzük az olyan primet, mely számjegyeinek összes forgatásából adódó
szám is prim. Például 719->971->179->719. Hány kerek prim van 1 millió alatt? Amit várunk egy kész implementáció,
mely kiszámolja és kiirja az egymillió alatti kerek primek számát.
 */
    public static void main(String[] args) {

        countCircularPrime();
       // System.out.println(isPrime(15));
    }


    public static void countCircularPrime(){
        int countCP =0;
        for (int i=0; i<1000000; i++){
         if (checkCircularPrime(i)) {
             countCP++;
            // System.out.println("This a circular prime = " + i);
         }
        }
        System.out.println("1 millió alatt " + countCP + " kerek prím van.");
    }

    // Function to check if the number is prime or not.
    static boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    // Function to check if the number is circular prime or not.
    static boolean checkCircularPrime(int N)
    {
        // Count digits.
        int count = 0, temp = N;
        while (temp>0) {
            count++;
            temp /= 10;
        }

        int num = N;
        while (isPrime(num)) {

            // Following three lines generate the next
            // circular permutation of a number. We
            // move last digit to first position.
            int rem = num % 10;
            int div = num / 10;
            num = (int)((Math.pow(10, count - 1)) * rem)
                    + div;

            // If all the permutations are checked and
            // we obtain original number exit from loop.
            if (num == N)
                return true;
        }

        return false;
    }

}