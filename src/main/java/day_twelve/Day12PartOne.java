package day_twelve;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Day12PartOne {

    private final Logger logger;
    private final String filePath;

    public Day12PartOne() {
        this.filePath = System.getProperty("user.dir") + "\\Input\\input_day_12";
        logger = LoggerFactory.getLogger(Day12PartOne.class);
    }

    public Day12PartOne(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day12PartOne.class);
    }

    /**
     * Calculates the total number of paths from a given input file that contains multiple path tuples.
     * @return An integer representing the number of paths from start - end in the given map input file
     */
    public int calculateTotalPaths() {
        var pathMap = readFile();
        return findAllPaths(pathMap);
    }

    /**
     * Finds all the possible paths for the given cave system following the specified formula:
     * 1. Caverns with uppercase names can be visited repeatedly provided they make unique routes
     * 2. Caverns with lowercase names can only be visited once per route
     * 3. All routes begin at the node "start"
     * 4. All routes finish at the node "end"
     * @param pathMap The mapping of all possible nodes and their edges in the cave
     * @return An integer indicating the number of paths through the cave without going through the small caves more than once each
     */
    private int findAllPaths(HashMap<String, ArrayList<String>> pathMap) {
        String currentCavern = "start";
        var visitedSmallCaverns = new HashSet<String>();
        return dfs(visitedSmallCaverns, pathMap, currentCavern);
    }

    /**
     * Searches the cave system to find all paths for a given system, given caverns already visited and where currently in the cave the iteration is.
     * @param visitedSmallCaverns The list of visited small caverns on this path through the cave system
     * @param pathMap The mapping of all possible nodes and their edges in the cave
     * @param currentCavern The current cavern to perform a DFS on
     * @return An integer indicating the number of successful paths on this tree
     */
    private int dfs(HashSet<String> visitedSmallCaverns, HashMap<String, ArrayList<String>> pathMap, String currentCavern) {
        int paths = 0;

        // Already visited this small cavern in the DFS, backtrack
        if (visitedSmallCaverns.contains(currentCavern)) {
            return 0;
        }

        // Found the exit, this DFS branch route is done
        if (currentCavern.equals("end")) {
            return 1;
        }

        // Visiting a small cavern on this branch, mark as visited
        if (currentCavern.toLowerCase().equals(currentCavern)) {
            visitedSmallCaverns.add(currentCavern);
        }

        // Iterate all possible DFS paths to the end
        for (String cavern : pathMap.get(currentCavern)) {
            var newVisited = (HashSet)visitedSmallCaverns.clone();
            paths += dfs(newVisited, pathMap, cavern);
        }

        return paths;
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
                    pathMap.put(currentPath[0], new ArrayList<>(Collections.singletonList(currentPath[1])));
                } else {
                    pathMap.get(currentPath[0]).add(currentPath[1]);
                }

                // Add 2nd direction
                if (!pathMap.containsKey(currentPath[1])) {
                    pathMap.put(currentPath[1], new ArrayList<>(Collections.singletonList(currentPath[0])));
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
