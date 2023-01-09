package day_twelve;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day12PartOne {

    private final Logger logger;
    private final String filePath;

    public Day12PartOne() {
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_12";
        logger = LoggerFactory.getLogger(Day12PartOne.class);
    }

    public Day12PartOne(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day12PartOne.class);
    }

    public int calculateTotalPaths() {
        var pathMap = readFile();

        return -1;
    }

    /**
     * Takes the input file and converts it into a map to use for performing calculations
     * @return A map containing all the bidirectional paths represented as a list of paths in the map
     */
    private HashMap<String, ArrayList<String>> readFile() {
        File file = new File(filePath);
        var pathMap = new HashMap<String, ArrayList<String>>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Parse the input
                String[] currentPath = line.split("-", 2);

                // Add 1st direction
                if (!pathMap.containsKey(currentPath[0])) {
                    pathMap.put(currentPath[0], new ArrayList<String>(Arrays.asList(currentPath[1])));
                } else {
                    pathMap.get(currentPath[0]).add(currentPath[1]);
                }

                // Add 2nd direction
                if (!pathMap.containsKey(currentPath[1])) {
                    pathMap.put(currentPath[1], new ArrayList<String>(Arrays.asList(currentPath[0])));
                } else {
                    pathMap.get(currentPath[1]).add(currentPath[0]);
                }
            }
            // Print hashmap for sanity
            for (var key: pathMap.keySet()) {
                System.out.println("Key " + key + " contains paths: " + pathMap.get(key));
            }

        } catch (Exception ex) {
            logger.info(ex.toString());
        }
        return pathMap;
    }
}
