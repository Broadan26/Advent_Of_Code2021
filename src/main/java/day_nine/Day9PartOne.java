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

        // DFS the map to determine the lowest point risk values
        // Formula: Lowest Point Values + 1
        // Return the risk of the lowest points
        return determineLowestPoints(digitMap);
    }

    /**
     * Performs a DFS on the map and determines if the current spot is a lowest point (Up, Down, Left, Right).
     * Adjusts the sum of the lowest point risk according to finding lowest points.
     * @param digitMap
     */
    private int determineLowestPoints(ArrayList<ArrayList<Integer>> digitMap) {
        int totalRisk = 0;
        for (int i = 0; i < digitMap.size(); i++) {
            for (int j = 0; j < digitMap.get(i).size(); j++) {
                // Booleans to handle checks
                boolean up = true, down = true, left = true, right = true;

                // Check Up
                if (i > 0 && digitMap.get(i-1).get(j) <= digitMap.get(i).get(j)) {
                    up = false;
                }
                // Check Down
                if (i+1 < digitMap.size() && digitMap.get(i+1).get(j) <= digitMap.get(i).get(j)) {
                    down = false;
                }
                // Check Left
                if (j > 0 && digitMap.get(i).get(j-1) <= digitMap.get(i).get(j)) {
                    left = false;
                }
                // Check Right
                if (j+1 < digitMap.get(i).size() && digitMap.get(i).get(j+1) <= digitMap.get(i).get(j)) {
                    right = false;
                }

                // If all checks are still true, point [i][j] is a lowest point
                if (up && down && left && right) {
                    totalRisk += digitMap.get(i).get(j) + 1;
                }
            }
        }
        return totalRisk;
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
