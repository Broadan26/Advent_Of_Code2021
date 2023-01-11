package day_fifteen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Day15PartOne {

    private final Logger logger;
    private final String filePath;

    public Day15PartOne() {
        logger = LoggerFactory.getLogger(Day15PartOne.class);
        this.filePath = System.getProperty("user.dir") + "\\Input\\input_day_15";
    }

    public Day15PartOne(String filePath) {
        logger = LoggerFactory.getLogger(Day15PartOne.class);
        this.filePath = filePath;
    }

    public int calculate() {
        // Create the 2D map
        var caveMap = createMap();

        // Traverse the map
        // Return the value at the end
        return bfs(caveMap);
    }

    private int bfs(ArrayList<ArrayList<Integer>> caveMap) {
        // Setup the BFS
        var queue = new ArrayDeque<String>();
        queue.add(0 + "," + 0);

        // Setup the graph weights assuming each cell has a weight of infinity until visited
        int[][] weights = new int[caveMap.size()][caveMap.get(0).size()];
        for (int row = 0; row < weights.length; row++) {
            for (int col = 0; col < weights[row].length; col++) {
                weights[row][col] = 1000000;
            }
        }
        weights[0][0] = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            // Remove and parse element
            String[] cell = queue.poll().split(",", 2);
            int row = Integer.parseInt(cell[0]);
            int col = Integer.parseInt(cell[1]);

            // Skip if cell has been visited
            if (row < 0 || col < 0 || row >= caveMap.size() || col >= caveMap.get(row).size()) {
                continue;
            }

            // Find the min weight
            if (row-1 >= 0) {
                weights[row][col] = Integer.min(weights[row][col], weights[row-1][col] + caveMap.get(row).get(col));
            }
            if (row+1 < caveMap.size()) {
                weights[row][col] = Integer.min(weights[row][col], weights[row+1][col] + caveMap.get(row).get(col));
            }
            if (col-1 >= 0) {
                weights[row][col] = Integer.min(weights[row][col], weights[row][col-1] + caveMap.get(row).get(col));
            }
            if (col+1 < caveMap.get(row).size()) {
                weights[row][col] = Integer.min(weights[row][col], weights[row][col+1] + caveMap.get(row).get(col));
            }

            // Continue BFS
            queue.add((row+1) + "," + col); // Go Down
            queue.add(row + "," + (col+1)); // Go Right
        }

        for (int[] row: weights) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

        return weights[caveMap.size()-1][caveMap.get(0).size()-1];
    }

    /**
     * Creates a traversable 2D map using the input file
     * @return A list with nested lists of integers that indicate the difficulty of traversing to that specific cell
     */
    private ArrayList<ArrayList<Integer>> createMap() {
        File file = new File(filePath);
        var caveMap = new ArrayList<ArrayList<Integer>>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                var caveRow = new ArrayList<Integer>();
                for (int col = 0; col < line.length(); col++) {
                    caveRow.add(Character.getNumericValue(line.charAt(col)));
                }
                caveMap.add(caveRow);
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }

        return caveMap;
    }
}
