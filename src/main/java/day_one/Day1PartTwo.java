package day_one;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day1PartTwo {

    private final Logger logger;
    private final String filePath;

    public Day1PartTwo() {
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_1";
        logger = LoggerFactory.getLogger(Day1PartTwo.class);
    }

    public Day1PartTwo(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day1PartTwo.class);
    }

    /**
     * Calculates the number of three-measurement sliding window integer increases in the imported file
     *
     * @return The number of three-measurement sliding window integer increases in the file
     */
    public int calculateSumIncreases() {
        // Get the list of integers in the input files
        var numsList = this.readFile();

        // Calculate increases
        int increases = 0;
        if (numsList.size() > 3) {
            int prev = 0;
            int currSum = numsList.get(0) + numsList.get(1) + numsList.get(2); // Initial Window
            for (int i = 3; i < numsList.size(); i++, prev++) {
                int nextSum = (currSum + numsList.get(i)) - numsList.get(prev); // Setup next window
                if (nextSum > currSum) { // Compare window sums
                    increases += 1;
                }

                // Remove tail, change head
                currSum = nextSum;
            }
        }

        return increases;
    }

    /**
     * Reads the file in the class and organizes into a list of integers
     *
     * @return A list of integers from the inputted file
     */
    private ArrayList<Integer> readFile() {
        File file = new File(filePath);
        var numsList = new ArrayList<Integer>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                numsList.add(Integer.valueOf(line));
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
        return numsList;
    }
}
