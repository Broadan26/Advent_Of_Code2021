package day_eight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Day8PartTwo {

    private final Logger logger;
    private final String filePath;

    public Day8PartTwo() {
        this.filePath = "Input/input_day_8";
        logger = LoggerFactory.getLogger(Day8PartTwo.class);
    }

    public Day8PartTwo(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day8PartTwo.class);
    }

    /**
     * Reads the class file and calculates the sum of all the four-digit numbers.
     *
     * @return The integer sum of all the four-digit numbers
     */
    public int calculateSumOfDigits() {
        // Contains elements before `|`
        var signalPatterns = readSignalPatterns();

        // Contains elements after `|`
        var digitList = readDigits();

        // Sort the characters for my sanity of string comparisons
        sortEachList(signalPatterns);
        sortEachList(digitList);

        // Parse the patterns using the following rules:
        // Unique: 1, 4, 7, 8 (with unique segments of 2, 4, 3, 7 respectively)
        // Same 1: 0, 6, 9 (with 6 segments each)
        // Same 2: 2, 3, 5 (with 5 segments each)
        // Overlaps:
        //  aaaa
        // b    c
        // b    c
        //  dddd
        // e    f
        // e    f
        //  gggg
        //
        // a = 0, 2, 3, 5, 6, 7, 8
        // b = 0, 4, 5, 6, 8, 9
        // c = 0, 1, 2, 3, 4, 7, 8, 9
        // d = 2, 3, 4, 5, 6, 8, 9
        // e = 0, 2, 6, 8
        // f = 0, 1, 3, 4, 5, 6, 7, 8, 9
        // g = 0, 2, 3, 5, 6, 8, 9
        var numberList = parseSignalPatterns(signalPatterns);

        // Convert digitsList to numbers and get the sum

        // Return the sum
        return -1;
    }

    /**
     * Parses the list of signal patterns and determines which characters translate to which digits.
     * @param signalPatterns The list containing a list of strings that define signal patterns
     * @return A list of hashmaps for each signal pattern allowing translation to digits
     */
    private ArrayList<HashMap<String,Integer>> parseSignalPatterns(ArrayList<ArrayList<String>> signalPatterns) {
        var numberList = new ArrayList<HashMap<String, Integer>>();

        // Run through all the provided patterns
        for (ArrayList<String> pattern: signalPatterns) {
            var currentPattern = new HashMap<String, Integer>();
            var reversePattern = new HashMap<Integer, String>();

            // Collect the uniques for later usage
            for (String number : pattern) {
                switch (number.length()) {
                    case 2: // Digit 1
                        currentPattern.put(number, 1);
                        reversePattern.put(1, number);
                        break;
                    case 3: // Digit 7
                        currentPattern.put(number, 7);
                        reversePattern.put(7, number);
                        break;
                    case 4: // Digit 4
                        currentPattern.put(number, 4);
                        reversePattern.put(4, number);
                        break;
                    case 7: // Digit 8
                        currentPattern.put(number, 8);
                        reversePattern.put(8, number);
                        break;
                    default:
                        continue;
                }
            }

            // Determine non-unique numbers based on uniques and other information
            while (currentPattern.size() < 10) {
                for (String number : pattern) {
                    if (number.length() == 5) {
                        if (determineSubset(number, reversePattern.get(7))) { // 7 confirms 3
                            currentPattern.put(number, 3);
                            reversePattern.put(3, number);
                        } else if (!reversePattern.containsKey(2) && !reversePattern.containsKey(5)) { // have neither 2 nor 5, confirm one of them
                            if (countMatches(number, reversePattern.get(4)) == 2) { // 2 has two matches with 4
                                currentPattern.put(number, 2);
                                reversePattern.put(2, number);
                            } else { // 5 has three matches with 4
                                currentPattern.put(number, 5);
                                reversePattern.put(5, number);
                            }
                        } else if (!reversePattern.containsKey(2)) { // No 2 so add 2
                            currentPattern.put(number, 2);
                            reversePattern.put(2, number);
                        } else { // 2 exists so add 5
                            currentPattern.put(number, 5);
                            reversePattern.put(5, number);
                        }
                    } else if (number.length() == 6) {
                        if (determineSubset(number, reversePattern.get(7)) && determineSubset(number, reversePattern.get(4))) { // 7 + 4 rules out 6 and 0
                            currentPattern.put(number, 9);
                            reversePattern.put(9, number);
                        } else if (determineSubset(number, reversePattern.get(7))) { // 7 rules out 6
                            currentPattern.put(number, 0);
                            reversePattern.put(0, number);
                        } else { // both 9 and 0 already in so add 6
                            currentPattern.put(number, 6);
                            reversePattern.put(6, number);
                        }
                    }
                }
            }
            // Add the resolved pattern
            numberList.add(currentPattern);
        }
        return numberList;
    }

    /**
     * A helper method for comparing non-unique numbers with their unique counterparts where possible.
     * @param number The number being compared to determine its value
     * @param comparison The string used as a comparison tool for checking the value of the number
     * @return A boolean indicating if the number is comparable to the comparison value
     */
    private boolean determineSubset(String number, String comparison) {
        StringBuilder numberChecker = new StringBuilder(number);
        for (String ch : comparison.split("")) {
            if (numberChecker.indexOf(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * A helper method for determining if the non-unique number is 2 or 5
     * @param number The number being compared to determine its value
     * @param comparison The string used as a comparison tool for checking the value of the number
     * @return An integer counting the number of matches between the number and the comparison number
     */
    private int countMatches(String number, String comparison) {
        int matches = 0;
        StringBuilder numberChecker = new StringBuilder(number);
        for (String ch : comparison.split("")) {
            if (numberChecker.indexOf(ch) > -1) {
                matches++;
            }
        }
        return matches;
    }

    /**
     * Used to alphabetize each string after the input file is parsed. Assists with later string comparisons.
     * @param listToSort The arraylist containing the list of strings needing to be sorted
     */
    private void sortEachList(ArrayList<ArrayList<String>> listToSort) {
        for (var stringList : listToSort) {
            for (int i = 0; i < stringList.size(); i++) {
                var charArray = stringList.get(i).toCharArray();
                Arrays.sort(charArray);
                stringList.set(i, new String(charArray));
            }
        }
    }

    /**
     * Reads the file in the class and organizes it into the observed patterns.
     * Each signal pattern contains all the digits 0-9.
     *
     * @return A list of the list of patterns associated with the input digits
     */
    private ArrayList<ArrayList<String>> readSignalPatterns() {
        File file = new File(filePath);
        var patternList = new ArrayList<ArrayList<String>>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Create new index for pattern
                patternList.add(new ArrayList<>());

                // Get the patterns
                String patterns = line.split("\\|", 2)[0];

                // Split the individual items in a pattern and add to associated list
                for (String item: patterns.split("\\s+")) {
                    patternList.get(patternList.size()-1).add(item.trim());
                }
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
        return patternList;
    }

    /**
     * Reads the file in the class and organizes it into the observed digits
     *
     * @return A list of the list of digits associated with the input patterns
     */
    private ArrayList<ArrayList<String>> readDigits() {
        File file = new File(filePath);
        var digitList = new ArrayList<ArrayList<String>>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Create new index for the digits
                digitList.add(new ArrayList<>());

                // Get the list of digits
                String inputDigits = line.split("\\|\\s+", 2)[1];

                // Split the individual items in the list of digits and add to associated list
                for (String item: inputDigits.split("\\s+")) {
                    digitList.get(digitList.size()-1).add(item.trim());
                }
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
        return digitList;
    }
}
