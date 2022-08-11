package day_eight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Day8PartOne {

    private static final ArrayList<HashSet<Character>> digits = new ArrayList<>();

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
        var signalPatterns = readSignalPatterns();
        var digitList = readDigits();



        return -1;
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
