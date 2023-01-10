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
        var instructionsList = createInstructions();

        // Perform folds
        foldMatrix(paperMatrix, instructionsList);

        // Calculate dots remaining
        return countDots(paperMatrix);
    }

    /**
     * Counts the number of dots present in the 2D matrix after fold(s) have been completed.
     * @param paperMatrix The 2D matrix that represents a piece of paper with dots on it
     * @return An integer value representing the number of dots present in the 2D matrix
     */
    private int countDots(boolean[][] paperMatrix) {
        int dotCount = 0;
        for (boolean[] row : paperMatrix) {
            for (boolean col : row) {
                if (col) {
                    dotCount++;
                }
            }
        }
        return dotCount;
    }

    private void foldMatrix(boolean[][] paperMatrix, ArrayList<String[]> instructionsList) {
        String firstFoldXY = instructionsList.get(0)[0];
        int firstFoldRowCol = Integer.parseInt(instructionsList.get(0)[1]);

        // Folding on X
        if (firstFoldXY.equalsIgnoreCase("x")) {
            for (int row = 0; row < paperMatrix.length; row++) {
                for (int col = 0; col < paperMatrix[row].length - firstFoldRowCol; col++) {
                    // Found a dot on side of paper to be folded
                    if (paperMatrix[row][firstFoldRowCol+col]) {
                        paperMatrix[row][firstFoldRowCol+col] = false;
                        paperMatrix[row][firstFoldRowCol-col] = true;
                    }
                }
            }
        // Folding on Y
        } else {
            for (int row = 0; row < paperMatrix.length - firstFoldRowCol; row++) {
                for (int col = 0; col < paperMatrix[row].length; col++) {
                    // Found a dot on side of paper to be folded
                    if (paperMatrix[firstFoldRowCol+row][col]) {
                        paperMatrix[firstFoldRowCol+row][col] = false;
                        paperMatrix[firstFoldRowCol-row][col] = true;
                    }
                }
            }
        }
    }

    /**
     * Utilizes the input file to create a list of instructions for folding the 2D matrix
     * @return A list of instructions for folding the 2D matrix
     */
    private ArrayList<String[]> createInstructions() {
        File file = new File(filePath);
        ArrayList<String[]> instructionsList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Instructions begin with keyword "fold"
                if (line.startsWith("fold")) {
                    String[] fold = line.split("=");
                    fold[0] = String.valueOf(fold[0].charAt(fold[0].length()-1));
                    instructionsList.add(fold); // x/y in 0, row/col in 1
                }
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
        return instructionsList;
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
