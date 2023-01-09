package day_eleven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day11PartOne {

    private final Logger logger;
    private final String filePath;

    public Day11PartOne() {
        this.filePath = System.getProperty("user.dir") + "\\Input\\input_day_11";
        logger = LoggerFactory.getLogger(Day11PartOne.class);
    }

    public Day11PartOne(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day11PartOne.class);
    }

    /**
     * Calculates the number of flashes that the given input of octopi produce after 100 steps have occurred.
     * @return An integer representing the number of flashes
     */
    public int calculateOctopiFlashes() {
        // Read the file to create the octopus map
        var octopusMap = readFile();

        // Perform the number of steps needed for result
        int numberOfSteps = 100;
        return performSteps(octopusMap, numberOfSteps);
    }

    /**
     * Performs the formula for octopi flashes. Formula:
     * Step 1: Initially increment all cells by 1.
     * Step 2: Check for cells with a value > 9. If found, increment all surrounding cells.
     * Step 3: Repeat step 2 until all cells are 9 or less.
     * Step 4: Set all cells that flashed to 0.
     * Step 5: Repeat from step 1
     * Repeat all steps until numberOfSteps is completed
     * @param octopusMap The octopus map to be worked with for determining total flashes
     * @param numberOfSteps How many steps to take when calculating flashes
     * @return An integer value indicating the total number of flashes that occurred on the map in the given number of steps
     */
    private int performSteps(ArrayList<ArrayList<Integer>> octopusMap, int numberOfSteps) {
        int totalFlashes = 0;

        // Run for the number of steps required
        for (int step = 0; step < numberOfSteps; step++) {
            // Initially increment every value by 1
            for (var row : octopusMap) {
                for (int col = 0; col < row.size(); col++) {
                    row.set(col, row.get(col)+1);
                }
            }

            boolean stepComplete = false;
            // Check for a step being complete before continuing on
            while (!stepComplete) {
                stepComplete = true;
                for (int row = 0; row < octopusMap.size(); row++) {
                    for (int col = 0; col < octopusMap.get(row).size(); col++) {
                        if (octopusMap.get(row).get(col) > 9) {
                            incrementAllSurroundingOctopi(octopusMap, row, col);
                            stepComplete = false;
                        }
                    }
                }
            }

            // Reset all flashed cells to 0
            for (int row = 0; row < octopusMap.size(); row++) {
                for (int col = 0; col < octopusMap.get(row).size(); col++) {
                    if (octopusMap.get(row).get(col) < 0) {
                        octopusMap.get(row).set(col, 0);
                        totalFlashes++;
                    }
                }
            }
        }
        return totalFlashes;
    }

    /**
     * Increments every possible cell around the current cell at [row, col] in the map.
     * @param octopusMap The map of octopi that is currently being worked with
     * @param row The current map row under consideration
     * @param col The current map column under consideration
     */
    private void incrementAllSurroundingOctopi(ArrayList<ArrayList<Integer>> octopusMap, int row, int col) {
        // Check up
        if (row > 0) {
            // Increment up
            octopusMap.get(row-1).set(col, octopusMap.get(row-1).get(col) + 1);
            // Increment up-left diagonal
            if (col > 0) {
                octopusMap.get(row-1).set(col-1, octopusMap.get(row-1).get(col-1) + 1);
            }
            // Increment up-right diagonal
            if (col+1 < octopusMap.get(row).size()) {
                octopusMap.get(row-1).set(col+1, octopusMap.get(row-1).get(col+1) + 1);
            }
        }
        // Check down
        if (row+1 < octopusMap.size()) {
            // Increment down
            octopusMap.get(row+1).set(col, octopusMap.get(row+1).get(col) + 1);
            // Increment down-left diagonal
            if (col > 0) {
                octopusMap.get(row+1).set(col-1, octopusMap.get(row+1).get(col-1) + 1);
            }
            // Increment down-right diagonal
            if (col+1 < octopusMap.get(row).size()) {
                octopusMap.get(row+1).set(col+1, octopusMap.get(row+1).get(col+1) + 1);
            }
        }
        // Check left
        if (col > 0) {
            // Increment left
            octopusMap.get(row).set(col-1, octopusMap.get(row).get(col-1) + 1);
        }
        // Check right
        if (col+1 < octopusMap.get(row).size()) {
            // Increment right
            octopusMap.get(row).set(col+1, octopusMap.get(row).get(col+1) + 1);
        }
        // Set current cell to a number that won't reach 0 to indicate it flashed
        octopusMap.get(row).set(col, Integer.MIN_VALUE);
    }

    /**
     * Takes the input file and converts it into a map to use for performing calculations
     * @return A list of a list of integers representing the energy levels of octopi
     */
    private ArrayList<ArrayList<Integer>> readFile() {
        File file = new File(filePath);
        var octopusMap = new ArrayList<ArrayList<Integer>>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                var octopusLine = new ArrayList<Integer>();

                // Convert the input line into a list of integer values
                for (int i = 0; i < line.length(); i++) {
                    octopusLine.add(Character.getNumericValue(line.charAt(i)));
                }
                // Add the line of octopi to the map if the line has octopi
                if (!octopusLine.isEmpty()) {
                    octopusMap.add(octopusLine);
                }
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
        return octopusMap;
    }
}
