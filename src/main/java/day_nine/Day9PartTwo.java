package day_nine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Day9PartTwo {

    private final Logger logger;
    private final String filePath;

    public Day9PartTwo() {
        logger = LoggerFactory.getLogger(Day9PartTwo.class);
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_9";
    }

    public Day9PartTwo(String filePath) {
        logger = LoggerFactory.getLogger(Day9PartTwo.class);
        this.filePath = filePath;
    }

    /**
     * Reads the class file and determines the lowest points and the total basin size associated with the lowest points.
     * @return An integer value representing the basin sizes multipled together
     */
    public int calculateBasinSizes() {
        // Parse the input file into a map of digits
        var digitMap = readDigitMap();

        // DFS the map to determine the lowest point risk values and their associated basin sizes
        var basinSizes = determineBasinSizes(digitMap);

        // Return the product of the largest basins
        return multiplyThreeLargestBasinSizes(basinSizes);
    }

    /**
     * Sorts the list of basin sizes placing the largest ones first in the list. Then multiplies the 3 largest for a result.
     * @param basinSizes A list of integers representing the size of all the basins found in the digitMap
     * @return The product of multiplying the 3 largest basin sizes
     */
    private int multiplyThreeLargestBasinSizes(ArrayList<Integer> basinSizes) {
        // No basins exist in the map
        if (basinSizes.isEmpty()) {
            return 0;
        }

        // Order by largest basins
        Collections.sort(basinSizes, Comparator.reverseOrder());

        // Multiply by the 3 largest basins
        return basinSizes.get(0) * basinSizes.get(1) * basinSizes.get(2);
    }

    /**
     * Performs a search on the map and determines if the current spot is a lowest point (Up, Down, Left, Right).
     * Then DFSes from that lowest point to find the size of the basin associated with that point.
     * @param digitMap A list of the list of digits indicating lowest/highest points from 0-9
     * @return A list of integers representing the size of all the basins found in the digitMap
     */
    private ArrayList<Integer> determineBasinSizes(ArrayList<ArrayList<Integer>> digitMap) {
        // Stores the list of basin sizes for final multiplication
        var basinSizes = new ArrayList<Integer>();

        // Search the map for lowest points
        for (int row = 0; row < digitMap.size(); row++) {
            for (int col = 0; col < digitMap.get(row).size(); col++) {

                // 9's cannot be part of a basin, skip over them
                if (digitMap.get(row).get(col) == 9) {
                    continue;
                }

                // Booleans to handle checks
                boolean up = true, down = true, left = true, right = true;

                // Check Up
                if (row > 0 && digitMap.get(row-1).get(col) <= digitMap.get(row).get(col)) {
                    up = false;
                }
                // Check Down
                if (row+1 < digitMap.size() && digitMap.get(row+1).get(col) <= digitMap.get(row).get(col)) {
                    down = false;
                }
                // Check Left
                if (col > 0 && digitMap.get(row).get(col-1) <= digitMap.get(row).get(col)) {
                    left = false;
                }
                // Check Right
                if (col+1 < digitMap.get(row).size() && digitMap.get(row).get(col+1) <= digitMap.get(row).get(col)) {
                    right = false;
                }

                // If all checks are still true, point [i][j] is a lowest point
                if (up && down && left && right) {
                    // DFS for the basin size recursively and store
                    basinSizes.add(dfs(digitMap, row, col));
                }
            }
        }
        return basinSizes;
    }

    /**
     * Standard recursive DFS formula that checks up, down, left, right on the provided digitMap
     * @param digitMap A list of the list of digits indicating lowest/highest points from 0-9
     * @param row The current row under consideration
     * @param col The current column under consideration
     * @return The sum of the size of the basin from this current point in the DFS
     */
    private int dfs(ArrayList<ArrayList<Integer>> digitMap, int row, int col) {
        // Base case. Stop when a basin edge is hit.
        if (digitMap.get(row).get(col) == 9) {
            return 0;
        }
        // Mark that cell has already been visited
        digitMap.get(row).set(col, 9);
        int sum = 1;

        // Check up
        if (row > 0) {
            sum += dfs(digitMap, row-1, col);
        }
        // Check down
        if (row+1 < digitMap.size()) {
            sum += dfs(digitMap, row+1, col);
        }
        // Check left
        if (col > 0) {
            sum += dfs(digitMap, row, col-1);
        }
        // Check right
        if (col+1 < digitMap.get(row).size()) {
            sum += dfs(digitMap, row, col+1);
        }
        return sum;
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
