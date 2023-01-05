package day_nine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day9PartOne {

    private final Logger logger;
    private final String filePath;

    public Day9PartOne() {
        logger = LoggerFactory.getLogger(Day9PartOne.class);
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_9";
    }

    public Day9PartOne(String filePath) {
        logger = LoggerFactory.getLogger(Day9PartOne.class);
        this.filePath = filePath;
    }

    /**
     * Reads the class file and determines the lowest points and the total risk associated with all the lowest points.
     * @return An integer value representing the total risk of all the lowest points
     */
    public int calculateRiskOfLowestPoint() {
        // Parse the input file into a map of digits
        var digitMap = readDigitMap();

        return -1;
    }

    /**
     * Reads the file in the class and organizes it into a more workable map for searching.
     * @return A list of the list of digits indicating lowest/highest points from 0-9
     */
    private ArrayList<ArrayList<Integer>> readDigitMap() {
        File file = new File(filePath);
        var digitMap = new ArrayList<ArrayList<Integer>>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Create new index for the digits
                digitMap.add(new ArrayList<Integer>());

                // Split each digit into its own array index
                String[] digitArray = line.split("", 1000);

                // Convert each array index into an integer and append to the map
                for (int i = 0; i < digitArray.length-1; i++) {
                    digitMap.get(digitMap.size()-1).add(Integer.parseInt(digitArray[i]));
                }
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
        return digitMap;
    }
}
