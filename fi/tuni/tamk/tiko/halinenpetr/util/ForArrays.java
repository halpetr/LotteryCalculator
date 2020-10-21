package fi.tuni.tamk.tiko.halinenpetr.util;

/**
 * The class Arrays contains methods for working with arrays and examining them.
 * 
 * Everything in this class Arrays is a method for manipulating different kinds
 * of arrays. Some methods are similar to existing java methods, but differ in some way that is required.
 * 
 * @author Petr Halinen
 */

public class ForArrays {
    /**
     * Converts a String array into an int array.
     * 
     * @param array is a String array
     * @return an int array
     */
    public static int[] toIntArray(String[] array) {
        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        return intArray;
    }

    /**
     * Returns either true or false depending if given value is found from array.
     * 
     * @param value the value that is being searched for
     * @param array the array that is being examined
     * @return true or false depending if the value is found from the array
     */
    public static boolean contains(int value, int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                result = 1;
            }
        }
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of same values that are contained within the two int
     * arrays that are being examined.
     * 
     * @param array1 first int array that is being compared
     * @param array2 second int array that is being compared
     * @return the number of same values contained in the two arrays
     */
    public static int containSameValues(int[] array1, int[] array2) {
        int result = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * This method examines an integer array for a number and determines if it is
     * already in said array or not.
     * 
     * @param number         the integer that is being searched for in the array
     * @param uniqueNumArray int array containing unique numbers
     * @return a boolean value of true or false depending on if the number is unique
     *         or already exists in the array.
     */

    public static boolean isUniqueNumber(int number, int[] uniqueNumArray) {
        boolean isUniqueNum = false;
        for (int i = 0; i < uniqueNumArray.length; i++) {
            if (number != uniqueNumArray[i]) {
                isUniqueNum = true;
            } else {
                isUniqueNum = false;
            }
        }
        return isUniqueNum;
    }

    /**
     * Method inserts int number into the index of the uniqueNumarray that
     * corresponds with integer arraySlot.
     * 
     * @param number         int that is being inserted into array
     * @param arraySlot      the index of array that will recieve the number
     * @param uniqueNumArray int array that contains the unique numbers
     * @return the int array with the new number added into it
     */

    public static int[] addNumToArray(int number, int arraySlot, int[] uniqueNumArray) {
        uniqueNumArray[arraySlot] = number;
        return uniqueNumArray;
    }

    /**
     * Method fills int array with number 0
     * 
     * @param array array that is being filled with 0
     * @return returns array that has 0 in every index
     */

    public static int[] zeroArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
        return array;
    }

    /**
     * Method checks if given array is full of numbers or not.
     * 
     * @param array the array that is being checked.
     * @return a boolean value of true or false depending on the array being full or
     *         not.
     */

    public static boolean isArrayFull(int[] array) {
        boolean isFull = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                isFull = true;
            } else {
                isFull = false;
            }
        }
        return isFull;
    }

    /**
     * Method prints integers from the given int array and adds a space " " after
     * every number.
     * 
     * @param array the array that is printed
     */

    public static void printIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * This method collects given user input into an int array, while making sure
     * that the given input is an integer and is a unique number.
     * 
     * Method collectNumbers uses other methods: Arrays.contains to check for
     * uniqueness of the given input integers, Arrays.addNumToArray for adding the
     * user input into the array and the Arrays.isArrayFull method to determine if
     * the array is already filled.
     * 
     * @param min                    the smallest acceptable integer value
     * @param max                    the largest acceptable integer value
     * @param arrayIndex             the index of the array into which the current
     *                               user input is stored (this should be "0", by
     *                               default)
     * @param array                  the int array into which the user inputs are
     *                               stored
     * @param errorMessageNonNumeric custom error message for when the input is not
     *                               an integer
     * @param errorMessageNonMinMax  custom error message for when the input is not
     *                               within the desired parameters (min and max)
     * @return the array into which the numbers were stored
     */

    public static int[] collectNumbers(int min, int max, int arrayIndex, int[] array, String errorMessageNonNumeric,
            String errorMessageNonMinMax) {
        boolean collectNumbers = true;
        while (collectNumbers) {
            System.out.println("Please give a unique number between [" + min + ", " + max + "]");
            int currentNumber = MyConsole.readInt(min, max, errorMessageNonNumeric, errorMessageNonMinMax);
            if (!ForArrays.contains(currentNumber, array)) {
                ForArrays.addNumToArray(currentNumber, arrayIndex, array);
                arrayIndex++;
            } else if (ForArrays.contains(currentNumber, array) == true) {
                System.out.println("Not unique numbers!");
            }
            if (ForArrays.isArrayFull(array)) {
                collectNumbers = false;
            }
        }
        return array;
    }

    /**
     * This method creates new int array the size of given parameter.
     * 
     * @param size the size of int array created
     * @return the created array
     */

    public static int[] createNewArray(int size) {
        int[] array = new int[size];
        return array;
    }

    /**
     * The method fills an array with integers from the desired number onwards (eg.
     * 1,2,3...), until the array is full.
     * 
     * @param min   the integer from which the method starts
     * @param array the array that is filled
     * @return the filled array
     */

    public static int[] fillArray(int min, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = min;
            min++;
        }
        return array;
    }

    /**
     * Method is used for sorting an int array. It returns the array sorted in
     * descending or ascending order, depenging on the param given to the method.
     * 
     * @param array the int array that is going to be sorted
     * @param order the sorting order, char 'a' for ascending 1,2,3.. and char 'd'
     *              for descending 3,2,1.
     * @return the array sorted in the desired order
     */

    public static int[] sortArray(int[] array, char order) {
        int min_index = 0;
        int[] returnArray = new int[array.length];
        for (int i = 0; i < array.length - 1; i++) {
            min_index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min_index]) {
                    min_index = j;
                }
            }
            int tempNum = array[min_index];
            array[min_index] = array[i];
            array[i] = tempNum;
        }
        if (order == 'a') {
            returnArray = array;
        } else if (order == 'd') {
            int x = array.length;
            for (int i = 0; i < array.length; i++) {
                returnArray[i] = array[x];
                x--;
            }
        }
        return returnArray;
    }

    /**
     * This method returns the String array with all the Strings that are shorter
     * than the longest String prefixed with the chosen prefix.
     * 
     * @param array  array to be prefixed
     * @param prefix the desired prefix String, e.g. "0".
     * @return the array with desired prefix prefixed to all Strings in the array
     *         that are shorter than the longest String in the array.
     */

    public static String[] prefixTheArray(String[] array, String prefix) {
        String longest = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > longest.length()) {
                longest = array[i];
            }
        }
        if (longest.length() > 1) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].length() < longest.length()) {
                    array[i] = prefix + array[i];
                }
            }
        } else if (longest.length() == 1) {
            for (int i = 0; i < array.length; i++) {
                array[i] = prefix + array[i];
            }
        }
        return array;
    }

    /**
     * This method returns the given int array as a String array.
     * 
     * @param original the int array that is converted to a String array.
     * @return the original array converted to a String array.
     */

    public static String[] intToStringArray(int[] original) {
        String[] array = new String[original.length];
        for (int i = 0; i < original.length; i++) {
            array[i] = Integer.toString(original[i]);
        }
        return array;
    }

    /**
     * This method prints a String array with spaces in between the array indexes.
     * 
     * @param array the array that is printed.
     */

    public static void printStringArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * This method prepares the int array for printing. It converts the int array
     * into a String array by using the method ForArrays.intoStringArray and then
     * prefixes the String array with the method ForArrays.prefixTheArray.
     * 
     * @param intArray int array that is prepared for printing.
     * @param prefix the prefix used as a param for the method prefixTheArray.
     * @return a String array that is ready to be printed out with the prefixes in place.
     */

    public static String[] prepareArrayForPrint(int[] intArray, String prefix) {
        String[] stringArray = intToStringArray(intArray);
        stringArray = prefixTheArray(stringArray, prefix);
        return stringArray;
    }

}