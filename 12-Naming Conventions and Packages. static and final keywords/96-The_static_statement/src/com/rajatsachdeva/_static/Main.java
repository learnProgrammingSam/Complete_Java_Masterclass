package com.rajatsachdeva._static;

public class Main {

    public static int multiplier = 7;

    public static void main(String[] args) {
        StaticTest firstInstance = new StaticTest("1st Instance");
        System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        StaticTest secondInstance = new StaticTest("2nd Instance");
        System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        StaticTest thirdInstance = new StaticTest("3rd Instance");
        System.out.println(thirdInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        // Non-Static method cannot be referenced from static context
        int answer = multiply(6);
        System.out.println("The Answer is " + answer);
        System.out.println("multiplier is " + multiplier);
    }

    public static int multiply(int number) {
        return number * multiplier;
    }
}
