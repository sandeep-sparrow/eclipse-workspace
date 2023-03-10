package com.java.utility;

import java.util.Arrays;

public class SecondHighestExample {

    /*

    *   there are 3 ways of getting 2nd largest number
    *   1. from array
    *   2. from array using arrays
    *   3. from array using collections - list
    *
    * */

    public static void main(String[] args) {

        int[] a = {1,5,7,2,9,3};
        int total = a.length;

        System.out.println("Array Data: " + Arrays.toString(a));
        System.out.println("Total Size of Array: " + total);

        System.out.println("\n Second largest number is: " + getSecondLargest(a, total));

    }

    public static int getSecondLargest(int[] a, int total){
        int max;
        for(int i=0; i<total; i++){
            for(int j=1+i; j<total; j++) {
                if (a[i] > a[j]) {
                    max = a[i];
                    a[i] = a[j];
                    a[j] = max;
                }
            }
        }
        return a[total-2];
    }
}
