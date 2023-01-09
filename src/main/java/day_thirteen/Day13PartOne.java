package day_thirteen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day13PartOne {

    private final Logger logger;
    private final String filePath;

    public Day13PartOne() {
        this.filePath = System.getProperty("user.dir") + "\\Input\\input_day_13";
        logger = LoggerFactory.getLogger(Day13PartOne.class);
    }

    public Day13PartOne(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day13PartOne.class);
    }

    /**
     * Creates a matrix and a set of instructions from the input file. Follows the instructions to determine how many dots are present.
     * @return Returns an integer indicating the number of dots from the input that are visible after all folds completed
     */
    public int calculateVisibleDots() {
        // Create the 2D matrix
        var paperMatrix = createMatrix();

        // Create list of instructions

        // Perform folds

        // Calculate dots remaining

        return -1;
    }

    /**
     * Utilizes the input file to create the 2D matrix for holding dots and fills in the dots once complete.
     * @return The created 2D matrix where true indicates a dot and false indicates no dot
     */
    private boolean[][] createMatrix() {
        File file = new File(filePath);
        boolean[][] paperMatrix = new boolean[1][1];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            int xMax = 0, yMax = 0;
            var pointsList = new ArrayList<Integer[]>();
            while ((line = bufferedReader.readLine()) != null) {

                // Skip the unnecessary bits to creating the matrix
                if (line.isEmpty() || line.startsWith("fold")) {
                    continue;
                }

                // Split coordinates to collect digits
                String[] coordinates = line.split(",", 2);

                // Look for max dimensions of input
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                if (x > xMax) {
                    xMax = x;
                }
                if (y > yMax) {
                    yMax = y;
                }

                // Store points for later usage
                pointsList.add(new Integer[]{x, y});
            }

            // Fill the matrix with true/false
            // True indicates a point, false indicates no point
            paperMatrix = new boolean[yMax+1][xMax+1];
            for (Integer[] point : pointsList) {
                paperMatrix[point[1]][point[0]] = true;
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }

        return paperMatrix;
    }
}
