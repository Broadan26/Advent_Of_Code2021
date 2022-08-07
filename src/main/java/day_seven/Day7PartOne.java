package day_seven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class Day7PartOne {

    private final Logger logger;
    private final String filePath;

    public Day7PartOne() {
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_7";
        logger = LoggerFactory.getLogger(Day7PartOne.class);
    }

    public Day7PartOne(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day7PartOne.class);
    }

    public int calculateFuelCost() {
        // Read the file and get the inputs
        var horizontalList = readFile();

        // Sort the inputs
        horizontalList.sort(Comparator.naturalOrder());

        // Find the minimum number of changes between min and max
        int minChanges = Integer.MAX_VALUE;
        int position = Integer.MAX_VALUE;
        for (int target = horizontalList.get(0); target < horizontalList.get(horizontalList.size()-1); target++) {
            int currentMoves = 0;
            for (Integer item: horizontalList) {
                currentMoves += Math.abs(item - target);
            }
            if (currentMoves < minChanges) {
                minChanges = currentMoves;
                position = target;
            }
        }

        logger.info("Minimum Changes: " + minChanges + ", Position: " + position);
        return minChanges;
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
