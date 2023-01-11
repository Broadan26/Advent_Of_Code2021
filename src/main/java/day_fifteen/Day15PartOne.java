package day_fifteen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
        // Set up the BFS
        var queue = new LinkedList<int[]>();
        queue.addLast(new int[]{0,0});
        int rowLength = caveMap.size();
        int colLength = caveMap.get(0).size();

        // Set up the graph weights assuming each cell has a weight of infinity until visited
        int[][] weights = new int[caveMap.size()][caveMap.get(0).size()];
        for (int[] weight : weights) {
            Arrays.fill(weight, 1000000);
        }
        weights[0][0] = 0; // Source has weight of 0 since it is starting point

        // Perform BFS
        while (!queue.isEmpty()) {
            // Remove and parse element
            int[] head = queue.removeFirst();
            int row = head[0];
            int col = head[1];
            //System.out.println("(" + row + "," + col + ")");

            // Find the min weights
            // Check up
            if (row-1 >= 0) {
                weights[row][col] = Math.min(weights[row][col], (weights[row-1][col] + caveMap.get(row).get(col)));
            }
            // Check left
            if (col-1 >= 0) {
                weights[row][col] = Math.min(weights[row][col], (weights[row][col-1] + caveMap.get(row).get(col)));
            }

            // Continue BFS
            if (col+1 < colLength) {
                queue.addLast(new int[]{row, (col+1)}); // Go Right
            }
            if (row+1 < rowLength) {
                queue.addLast(new int[]{(row+1), col}); // Go Down
            }
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
