package com.scaler.core.java_1_beginner.intro_07_functions;

/**
 * @created 04/08/22 12:36 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
class Main {

    public static void main(String[] args) {

        // decimal number
        int num = 2;
        System.out.println("Decimal to Binary");

        // call method to convert to binary
        long binary = countPrimes(num);

        System.out.println("\n" + num + " = " + binary);

        int a = 2;
        int result = solve(a);
        System.out.println(result);
    }

    public static int convertBinaryToDecimal(long num) {
        int decimalNumber = 0, i = 0;
        long remainder;

        while (num != 0) {
            remainder = num % 10;
            num /= 10;
            decimalNumber += remainder * Math.pow(2, i);
            ++i;
        }

        return decimalNumber;
    }

    public static long convertDecimalToBinary(int n) {

        long binaryNumber = 0;
        int remainder, i = 1, step = 1;

        while (n!=0) {
            remainder = n % 2;
            //System.out.println("Step " + step++ + ": " + n + "/2");

            //System.out.println("Quotient = " + n/2 + ", Remainder = " + remainder);
            n /= 2;

            binaryNumber += remainder * i;
            i *= 10;
        }

        return binaryNumber;
    }
    public static int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        for(int i=0; i<n; i++){
            primes[i] = true;
        }

        for(int i=2; i*i<n; i++){
            if(primes[i]){
                for(int j=i; j*i<n; j++){
                    primes[i*j] = false;
                }
            }
        }
        int primeCount = 0;
        for(int i=2; i<primes.length; i++){
            if(primes[i]){
                primeCount++;
            }
        }
        return primeCount;
    }

    private static int solve(int A) {
        int primeCounts = 0;

        for(int i=2; i <= A ; i++){
            if(isPrime(i)) {
                primeCounts++;
            }
        }
        return primeCounts;
    }

    public static boolean isPrime(int n) {
        if(n == 1 || n == 0) {
            return false;
        }
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
