package com.rajatsachdeva;

// Java If-Else

import java.util.Scanner;

/**
 * Task
 Given an integer, n , perform the following conditional actions:

 If n is odd, print Weird
 If n is even and in the inclusive range of 2 to 5, print Not Weird
 If n is even and in the inclusive range of 6 to 20, print Weird
 If n is even and greater than 20, print Not Weird
 Complete the stub code provided in your editor to print whether or not  is weird.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String ans="";
        if(n%2==1){
            ans = "Weird";
        }
        else{

            //Complete the code

        }
        System.out.println(ans);
    }
}
