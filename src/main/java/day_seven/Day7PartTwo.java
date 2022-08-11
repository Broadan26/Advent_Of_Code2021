package day_seven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class Day7PartTwo {

    private final Logger logger;
    private final String filePath;

    public Day7PartTwo() {
        this.filePath = "Input/input_day_7";
        logger = LoggerFactory.getLogger(Day7PartTwo.class);
    }

    public Day7PartTwo(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day7PartTwo.class);
    }

    /**
     * Calculates the minimum fuel cost and associated position to make all values in the input the equal.
     * Fuel cost follows the series 1 + 2 + 3 + 4... for subsequent moves.
     *
     * @return An integer representing the minimum number of fuel cost.
     */
    public long calculateFuelCost() {
        // Read the file and get the inputs
        var horizontalList = readFile();

        // Sort the inputs
        horizontalList.sort(Comparator.naturalOrder());

        // Find the minimum number of changes between min and max
        long minFuelCost = Long.MAX_VALUE;
        int position = Integer.MAX_VALUE;
        for (int target = horizontalList.get(0); target < horizontalList.get(horizontalList.size()-1); target++) {
            long fuelCost = 0L;
            for (Integer item: horizontalList) {
                // Find needed moves
                int moves = Math.abs(item - target);

                // Use Euler's Series Summation to get fuel cost
                fuelCost += ((long) moves * (moves + 1) / 2);
            }
            if (fuelCost < minFuelCost) {
                minFuelCost = fuelCost;
                position = target;
            }
        }

        logger.info("Minimum Changes: " + minFuelCost + ", Position: " + position);
        return minFuelCost;
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
                int[] inputArray = Stream.of(line.split(",")).mapToInt(Integer::parseInt).toArray();

                for (int val: inputArray) {
                    numsList.add(val);
                }
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
        return numsList;
    }
}
