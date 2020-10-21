
package fi.tuni.tamk.tiko.halinenpetr;

import fi.tuni.tamk.tiko.halinenpetr.util.*;

/**
 * Class LottoApp contains the main method for the lotto application.
 * 
 * Contains the parameters that different methods require.
 * 
 * @author Petr Halinen
 */

public class LottoApp {
    public static void main(String[] args) {
        // If user used a command line argument to input the numbers:
        int[] uiNumbers = new int[7];
        boolean collect = true;
        int firstArg;
        int j = 0;
        if (args.length > 0) {
            while (collect) {
                try {
                    firstArg = Integer.parseInt(args[j]);
                    uiNumbers[j] = firstArg;
                    j++;
                } catch (NumberFormatException e) {
                    System.err.println("Argument" + args[j] + " must be an integer.");
                }
                if (ForArrays.isArrayFull(uiNumbers)) {
                    collect = false;
                }
            }
        }
        
        // Integers:
        int min = 1;
        int max = 40;
        int arrayIndex = 0;
        int numberOfWeeks = 0;
        int numOfSameValues = 0;
        int desiredNumOfSameValues = 1;
        // Strings:
        String errorMessageNonNumeric = "Your input is not a number, please try again:";
        String errorMessageNonMinMax = "Your input is not between " + min + " - " + max + ", please try again:";
        String playUntilWonInLifetime = "Do you wish to play until you win in a lifetime?";
        String winningNums = "Do you wish to see the winning numbers each time you get one more right number?";
        String uNum = "User lotto:  ";
        String randNum = "Random lotto:";
        // Booleans:
        boolean playForEver = true;
        boolean numsThatWon = true;
        playForEver = ForStrings.askAQuestion(playUntilWonInLifetime);
        numsThatWon = ForStrings.askAQuestion(winningNums);
        boolean playLotto = true;
        // Arrays:
        int[] userNumbers = new int[7];
        // Getting user numbers:
        // If user did NOT input numbers as a command line argument:
        if (!ForArrays.isArrayFull(uiNumbers)) {
            ForArrays.collectNumbers(min, max, arrayIndex, userNumbers, errorMessageNonNumeric, errorMessageNonMinMax);
            ForArrays.sortArray(userNumbers, 'a');
            ForArrays.printIntArray(userNumbers);
            System.out.println();
        // If user used a command line argument to input the numbers    
        } else {
            userNumbers = uiNumbers;
            ForArrays.sortArray(userNumbers, 'a');
            ForArrays.printIntArray(userNumbers);
            System.out.println();
        }
        // Start of the App:
        while (playLotto) {
            int[] randomNums = calculateLotto(40, 7);
            ForArrays.sortArray(randomNums, 'a');
            numberOfWeeks++;
            numOfSameValues = ForArrays.containSameValues(userNumbers, randomNums);
            if (numOfSameValues == desiredNumOfSameValues) {
                // If player wanted to see the winning numbers:
                if (numsThatWon) {
                    ForStrings.printNumbers(userNumbers, uNum, "0");
                    ForStrings.printNumbers(randomNums, randNum, "0");
                }
                int years = Mathem.timePeriodChange(numberOfWeeks, '/', 52);
                // This prints out how many were right and how many years it took:
                System.out.println(ForStrings.numberOfSameValues(numOfSameValues, desiredNumOfSameValues, years));
                desiredNumOfSameValues++;
                // If player wanted to play until they win in a lifetime:
                if (playForEver) {
                    if (numOfSameValues == 7 && years < 120) {
                        System.out.println("You won!");
                        playLotto = false;
                    } else if (numOfSameValues == 7) {
                        System.out.println("You won!");
                        System.out.println("Althought it took more than a lifetime, let's try it again.");
                        numberOfWeeks = 0;
                        desiredNumOfSameValues = 1;
                    }
                }
                // If player just wanted to play until they win once:
                if (!playForEver && numOfSameValues == 7) {
                    System.out.println("You won!");
                    playLotto = false;
                }
            }
        }
    }

    /**
     * Compiles an array of desired amount of random numbers from the desired range.
     * Always starting from int "1".
     * 
     * @param sizeOfArrayToDrawFrom  the size of the array to draw from. eg. 40
     *                               means the numbers will be 1-40.
     * @param desiredAmountOfNumbers the desired amount of random numbers
     * @return int array with the random numbers
     */

    public static int[] calculateLotto(int sizeOfArrayToDrawFrom, int desiredAmountOfNumbers) {
        boolean collectRandomNums = true;
        int[] numbersToDrawFrom = ForArrays.createNewArray(sizeOfArrayToDrawFrom);
        int[] lottoNumbers = ForArrays.createNewArray(desiredAmountOfNumbers);
        numbersToDrawFrom = ForArrays.fillArray(1, numbersToDrawFrom);
        int lottoNumIndex = 0;
        while (collectRandomNums) {
            int index = Mathem.getRandom(0, numbersToDrawFrom.length - 1);
            int randomNum = numbersToDrawFrom[index];
            numbersToDrawFrom = Mathem.removeIndex(numbersToDrawFrom, randomNum);
            lottoNumbers[lottoNumIndex] = randomNum;
            lottoNumIndex++;

            if (lottoNumIndex == desiredAmountOfNumbers) {
                collectRandomNums = false;
            }
        }
        return lottoNumbers;
    }
}