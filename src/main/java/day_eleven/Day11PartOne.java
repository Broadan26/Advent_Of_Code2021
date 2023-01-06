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
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_11";
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
        var octopusMap = readFile();



        return -1;
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
