package fi.tuni.tamk.tiko.halinenpetr.util;

import java.io.Console;

/**
 * Contains methods for manipulating Strings.
 * 
 * @author Petr Halinen
 */

public class ForStrings {

    /**
     * Method return a string with the number of same values and time it took to get
     * them. eg. "Got 2 right! Took 7 years"
     * 
     * @param numberOfSameValues     number of same values
     * @param desiredNumOfSameValues desired number of same values, in this case 7
     *                               lotto numbers
     * @param amountOfTime           indicates the amount of time it took
     * @return returns a string with the parameter values within it
     */

    public static String numberOfSameValues(int numberOfSameValues, int desiredNumOfSameValues, int amountOfTime) {
        String numOfValues = "";
        if (numberOfSameValues >= desiredNumOfSameValues) {
            numOfValues = ("Got " + numberOfSameValues + " right! " + "Took " + amountOfTime + " years");
        }
        return numOfValues;
    }

    /**
     * Method is for asking user a question. "Y/N" will be added to the end of the
     * question.
     * 
     * @param question the question is asked from the user
     * @return true or false, depending on the user input "Y/N" yes or no.
     */

    public static boolean askAQuestion(String question) {
        boolean ask = true;
        boolean answer = true;
        Console c = System.console();
        while (ask) {
            System.out.println(question + " Y/N");
            String ans = c.readLine();
            if (ans.equalsIgnoreCase("y")) {
                ask = false;
            } else if (ans.equalsIgnoreCase("n")) {
                answer = false;
                ask = false;
            } else {
                System.out.println(ans + " is not a valid answer. Please try again.");
                ask = true;
            }
        }
        return answer;
    }

    public static void printNumbers(int [] array, String beforeNumbers, String prefix) {
        System.out.print(beforeNumbers + "   [");
        String[] stringToPrint = ForArrays.prepareArrayForPrint(array, prefix);
        ForArrays.printStringArray(stringToPrint);
        System.out.print("]");
        System.out.println();
    }

}