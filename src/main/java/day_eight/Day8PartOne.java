package day_eight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day8PartOne {

    private final Logger logger;
    private final String filePath;

    public Day8PartOne() {
        this.filePath = "Input/input_day_8";
        logger = LoggerFactory.getLogger(Day8PartOne.class);
    }

    public Day8PartOne(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day8PartOne.class);
    }

    /**
     * Reads the class file and calculates the number of times that simple digits are found in the input.
     *
     * @return The number of instances of 1,4,7,8 that appear in the digits input
     */
    public int findObviousDigits() {
        // Contains elements before `|`
        // Useful for parsing harder digits in part 2
        var signalPatterns = readSignalPatterns();

        // Contains elements after `|`
        var digitList = readDigits();

        // Counts the digits with a unique number of segments
        // Unique: 1, 4, 7, 8 (with unique segments of 2, 4, 3, 7 respectively)
        // Same 1: 0, 6, 9 (with 6 segments each)
        // Same 2: 2, 3, 5 (with 5 segments each)
        var countUniqueSegments = countUniqueSegments(digitList);

        return countUniqueSegments;
    }

    /**
     * Counts the number of distinct digits in the list of digits provided.
     * @param digitList An array list containing the multiple lists of digits to count for uniques
     * @return The count of all the unique digits present in the digitList
     */
    private int countUniqueSegments(ArrayList<ArrayList<String>> digitList) {
        int count = 0;
        for (var digits : digitList) {
            for (String digit : digits) {
                switch(digit.length()) {
                    case 2: // Digit 1
                    case 3: // Digit 7
                    case 4: // Digit 4
                    case 7: // Digit 8
                        count++;
                        break;
                    default:
                        continue;
                }
            }
        }
        return count;
    }

    /**
     * Reads the file in the class and organizes it into the observed patterns
     *
     * @return A list of the list of patterns associated with the input digits
     */
    private ArrayList<ArrayList<String>> readSignalPatterns() {
        File file = new File(filePath);
        var patternList = new ArrayList<ArrayList<String>>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

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

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

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
