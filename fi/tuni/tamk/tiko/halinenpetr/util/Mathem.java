package fi.tuni.tamk.tiko.halinenpetr.util;

/**
 * The class Mathem contains methods for basic mathematical functions.
 * 
 * Not all the methods in the class Mathem are for mathematical functions, some
 * are for obtaining random values.
 * 
 * @author Petr Halinen
 */

public class Mathem {
    /**
     * Returns a random int value that is within the parameters.
     * 
     * @param min the argument that determines the smallest possible random number
     * @param max the argument that determines the largest possible random number
     * @return int value that is within the given parameters.
     */
    public static int getRandom(int min, int max) {
        int result = min + (int) (java.lang.Math.random() * ((max - min) + 1));
        return result;
    }

    /**
     * Method is used to remove one index from an int array.
     * 
     * @param original the array that you want to remove an index from
     * @param index the index that you want to remove
     * @return the int array with the index removed from it
     */

    public static int[] removeIndex(int [] original, int index) {
        int [] newArray = null;
        for(int i = 0; i < original.length; i++){
            if(original[i] == index){
              newArray = new int[original.length - 1];
              for(int x = 0; x < i; x++){
                newArray[x] = original[x];
              }
              for(int j = i; j < original.length - 1; j++){
                newArray[j] = original[j+1];
              }
              break;
            }
          }
        return newArray;
    }

    /**
     * Method is used to change amount of one timeperiod to another. e.g. Days to week, or weeks to days.
     * 
     * @param numberOfTimePeriods the amount of original timeperiods
     * @param operator depending on the change either 'x' or '/' is used as the operator which defines what is done to the amount of timeperiods.
     * @param ratioOfNewToOld the ratio of one timeperiod to another. e.g. 7 (there are 7 days in a week).
     * @return the amount of timeperiods after the change e.g. if given "7" days returns "1" week.
     */

    public static int timePeriodChange(int numberOfTimePeriods, char operator, int ratioOfNewToOld) {
        int result = 0;
        if (operator == 'x') {
            result = numberOfTimePeriods * ratioOfNewToOld;
        } else if (operator == '/') {
            result = numberOfTimePeriods / ratioOfNewToOld;
        }
        return result;
    }
}
