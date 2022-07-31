package day_six;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Day6PartOne {

    private final Logger logger;
    private final String filePath;

    public Day6PartOne() {
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_6";
        logger = LoggerFactory.getLogger(Day6PartOne.class);
    }

    public Day6PartOne(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day6PartOne.class);
    }

    /**
     * Calculates the number of fish after 80 spawning cycles utilizing the class input file.
     *
     * @return The number of fish after 80 spawning cycles have been completed
     */
    public int calculateTotalFish() {
        // Read the input file and convert to a hashmap
        var fishMap = readFile();

        // Simulate the fish spawning process
        spawnFish(fishMap);

        // Calculate number of fish at end of 80 days of spawning
        int count = 0;
        for (Map.Entry<Integer, Integer> entry: fishMap.entrySet()) {
            count += entry.getValue();
        }

        return count;
    }

    /**
     * Simulates the fish spawning process following the rules as described:
     * 1) Every spawn, each existing fish has its timer drop by 1
     * 2) When a fish's timer hits 0 it is reset to 6 and another fish is added at timer 8
     * 3) This continues for 80 spawning cycles
     * @param fishMap A dictionary containing the fish's spawning timer and the number of fish with that timer
     */
    private void spawnFish(Map<Integer, Integer> fishMap) {

        // Controls the number of spawn cycles
        for (int cycle = 0; cycle < 80; cycle++) {
            var tempFishMap = new TreeMap<Integer, Integer>(fishMap);

            // Controls generic fish timer changes
            for (int key = 1; key <= 8; key++) {
                if (tempFishMap.containsKey(key)) {
                    fishMap.put(key - 1, tempFishMap.get(key));
                    fishMap.replace(key, tempFishMap.get(key), 0);
                }
            }
            // When fish timer is at 0
            if (tempFishMap.containsKey(0)) {
                int newFish = tempFishMap.get(0);
                // Update fish at 6
                if (fishMap.containsKey(6)) {
                    fishMap.put(6, fishMap.get(6) + newFish);
                } else {
                    fishMap.put(6, newFish);
                }
                // Update fish at 8
                fishMap.put(8, newFish);
            }
        }
    }

    /**
     * Reads the file in the class and organizes it into a hashmap denoting:
     * Key: Fish birth timer
     * Value: Number of fish with that timer
     *
     * @return A hashmap of integers representing the birth timers of fish and how many have that timer.
     */
    private Map<Integer, Integer> readFile() {
        File file = new File(filePath);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.length() != 0) {
                    return createMap(line);
                }
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
        return Collections.emptyMap();
    }

    /**
     * Converts the comma separated list of numbers into a more readily usable hashmap for calculations.
     * @param line The comma separated list of numbers that needs to be parsed
     * @return A hashmap of integers representing the birth timers of fish and how many have that timer.
     */
    private TreeMap<Integer, Integer> createMap(String line) {
        var fishMap = new TreeMap<Integer, Integer>();

        // Split the list and organize the numbers in a hashmap
        String[] inputList = line.split(",");
        for (String number: inputList) {
            int key = Integer.parseInt(number);
            if (fishMap.containsKey(key)) {
                fishMap.replace(key, fishMap.get(key), fishMap.get(key)+1);
            } else {
                fishMap.put(key, 1);
            }
        }
        return fishMap;
    }
}