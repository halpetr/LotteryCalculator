package fi.tuni.tamk.tiko.halinenpetr.util;

import java.io.Console;

/**
 * The class MyConsole contains methods for reading user input and examining it.
 * 
 * @author Petr Halinen
 */

public class MyConsole {

    /**
     * The method readInt returns the user input if it is in fact an integer.
     * The method readInt examines user input and checks if it is an integer or not and if it is within desired integer parameters.
     * 
     * If the input given by the user is not an integer, the method displays errorMessageNonNumeric which is a custom errormessage.
     * If the input is an integer, the method checks if it is within the given parameters larger or equal to min
     * and smaller or equal to max.
     * 
     * @param min the smallest acceptable integer value
     * @param max the largest acceptable integer value
     * @param errorMessageNonNumeric custom errormessage for when the input is not an integer
     * @param errorMessageNonMinMax custom errormessage for when the input is not within desired parameters
     * @return an integer that is valid, given the parameters
     */

    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinMax) {
        Console c = System.console();
        boolean isInteger = false;
        boolean isNumeric = false;
        boolean isMinMax = false;
        int input = 0;
        
        while (!isInteger) {
            while (!isNumeric) {
                try {
                    input = Integer.parseInt(c.readLine());
                    isNumeric = true;
                } catch (NumberFormatException e) {
                    System.out.println(errorMessageNonNumeric);
                }
            }
            if (input >= min && input <= max) {
                isMinMax = true;
            } else {
                System.out.println(errorMessageNonMinMax);
                isNumeric = false;
            }
            if (isNumeric == true && isMinMax == true) {
                isInteger = true;
            }
        }
        return input;
    }

    /**
     * This method compares 2 numbers according to the parameter given in the String.
     * 
     * The String comparingParam can be the following: smaller (when you want the method to return the smaller of the 2 int),
     * bigger (when you want the bigger one of the 2 int).
     * 
     * @param num1 int that is being compared
     * @param num2 the other int that is being compared
     * @param comparingParam "smaller" or "bigger" depending on which one is the desired return of the method
     * @return the smaller or bigger int
     */

    public static int compareNumbers(int num1, int num2, String comparingParam) {
        int big = 0;
        int small = 0;
        int same = 0;
        if (num1 < num2) {
            big = num2;
            small = num1;
        } else if (num1 > num2) {
            big = num1;
            small = num2;
        } else {
            same = num1;
        }
        if (comparingParam.equalsIgnoreCase("smaller")) {
            return small;
        } else if (comparingParam.equalsIgnoreCase("bigger")) {
            return big;
        } else {
            return same;
        }
    }
}