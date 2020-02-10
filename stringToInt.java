/* Author: Trish Lam
* Date: 2/9/2020
* File: stringToInt.java
* For: Taboola Backend Engineer Intern Take Home Test (Part 1)
* Purpose: This file is a Java program that takes a string input and converts it to an integer without
using the build-in parse function.
*/

public class stringToInt {

    /* Solution 1: My Brute Force Approach
    * Uses the ASCII Table Values to calculate what the character of each
    * index is in Integer form. If input is null or cannot be an integer, the
    * function then returns -1;
    */
    public static int toInt(String input) {
        if (input == null || input.isEmpty()) {
            //Returning -1 notifies user that string cannot be translated into int
            return -1;
        }
        int index = input.length() - 1;
        int multiple = 1;
        int answer = 0;
        boolean negative = false;
        // Iterates through string to calculate the value of each integer and its place value
        for (int i = index; i >= 0; i--) {
            char currChar = input.charAt(i);
            int value = currChar - '0';
            // If the character value is '-'
            if (value == -3) {
                negative = true;
                break;
            }
            // If the character value is not 0-9, it cannot be an integer
            else if (value > 9) {
                return -1;
            }
            answer += (value * multiple);
            // Increasing the multiple to account for the next tens place
            multiple *= 10;
        }
        // Returns negative since '-' was accounted for with a boolean
        if (negative) {
            return answer * -1;
        }
        return answer;
    }

    /* Test Cases in the main method to print out expected values */
    public static void main(String args[]){
        //Test Brute Force Solution
        System.out.println("Testing Solution #1");

        //Regular Integer
        String thirteen = "13";
        int thirteenInt = toInt(thirteen);
        System.out.println("Regular integer [13]: " + thirteenInt);

        //Empty String
        String empty = "";
        int emptyInt = toInt(empty);
        System.out.println("Empty String [-1]: " + emptyInt);

        //Lowercase Letter
        String lowerABC = "abc";
        int abcInt = toInt(lowerABC);
        System.out.println("Not an integer [-1]: " + abcInt);

        //Uppercase Letter
        String upperABC = "ABC";
        int ABCInt = toInt(upperABC);
        System.out.println("Not an integer [-1]: " + ABCInt);

        //Negative Integer
        String negative = "-123";
        int negInt = toInt(negative);
        System.out.println("Negative integer [-123]: " + negInt);
    }
}






