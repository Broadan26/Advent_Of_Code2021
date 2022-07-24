package day_one;

import org.slf4j.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day1PartOne {

    private final Logger logger;
    private final String filePath;

    public Day1PartOne() {
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_1";
        logger = LoggerFactory.getLogger(Day1PartOne.class);
    }

    public Day1PartOne(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day1PartOne.class);
    }

    /**
     * Calculates the number of integer increases in the imported file
     *
     * @return The number of integer increases in the file
     */
    public int calculateIncreases() {
        // Get the list of integers in the input files
        var numsList = this.readFile();

        // Calculate increases
        int increases = 0;
        if (numsList.size() > 1) {
            int prev = numsList.get(0);
            for (int num : numsList) {
                if (num > prev) {
                    increases += 1;
                }
                prev = num;
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
