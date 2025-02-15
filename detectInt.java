/* Author: Trish Lam
* Date: 2/9/2020
* File: detectInt.java
* For: Taboola Backend Software Engineer Intern Take Home Test (Part 2)
* Purpose: This file is a Java program that take a input and detect whether there’s integer in
there.
*/

public class detectInt {

    /* Solution 1: My Brute Force Approach
    * Uses the ASCII Table Values to calculate whether the character at
    * each index is an integer or not. Once an integer is determined, the
    * function returns true. Else, it will return false.
    */
    public static boolean hasInt(String input) {
        if (input == null) {
            return false;
        }
        int index = input.length() - 1;
        for (int i = index; i >= 0; i--) {
            char currChar = input.charAt(i);
            // Calculates actual character value
            int value = currChar - '0';
            // If it returns an integer, return true
            if (value > -1 && value < 10) {
                return true;
            }
        }
        return false;
    }

    /* Test Cases in the main method to print out expected values */
    public static void main(String args[]){
        //Test Brute Force Solution
        System.out.println("Testing Solution #1");

        //Prompt Example 1
        String example1 = "45222";
        boolean ex1 = hasInt(example1);
        System.out.println("Example 1 [true]: " + ex1); 

        //Prompt Example 2
        String example2 = "This Is A Test4me";
        boolean ex2 = hasInt(example2);
        System.out.println("Example 2 [true]: " + ex2); 

        //Prompt Example 3
        String example3 = "IAMGOOD";
        boolean ex3 = hasInt(example3);
        System.out.println("Example 3 [false]: " + ex3); 

        //Regular Combination of Letters and Numbers
        String combo = "h3ll0";
        boolean combination = hasInt(combo);
        System.out.println("Regular combination [true]: " + combination);

        //Empty String
        String empty = "";
        boolean emptyInt = hasInt(empty);
        System.out.println("Empty String [false]: " + emptyInt);

        //Null String
        String nullString = null;
        boolean nullStringInt = hasInt(nullString);
        System.out.println("Null String [false]: " + nullStringInt);

        //Lowercase Letter
        String lower = "abcdefghijklmnopqrstuvwxyz";
        boolean lowercase = hasInt(lower);
        System.out.println("All lowercase letters [false]: " + lowercase);

        //Uppercase Letter
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        boolean uppercase = hasInt(upper);
        System.out.println("All uppercase letters [false]: " + uppercase);

        //Negative Integer
        String negative = "-123";
        boolean negInt = hasInt(negative);
        System.out.println("Negative integer [true]: " + negInt);

        //All other ASCII Values excluding Integers
        String all = " !\"#$%&'()*+,-./:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        boolean allChars = hasInt(all);
        System.out.println("All ASCII Values without Integers [false]: " + allChars);
    }
}