package day_five;

import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day5PartTwo {

    private final Logger logger;
    private final String filePath;

    public Day5PartTwo() {
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_5";
        logger = LoggerFactory.getLogger(Day5PartTwo.class);
    }

    public Day5PartTwo(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day5PartTwo.class);
    }

    /**
     * Calculates the number of overlaps of a given input file containing pairs of (x,y) coordinates depicting a line in a 2D plane.
     * Assumes that the 2D plane starts at coordinates (0,0) and extends to an arbitrary X and Y coordinate.
     * Allows for 45 degree diagonal lines to be considered in the plane rather than just horizontal and vertical lines.
     *
     * @return An integer representing the number of points that overlap in the sequence of line segments.
     */
    public int calculateOverlaps() {
        // Read the file and get list of points
        var pointsList = readFile();

        // Determine the size of the 2D plane
        int maxX = getValueXMax(pointsList) + 1;
        int maxY = getValueYMax(pointsList) + 1;

        // Create the 2D plane instantiated with all zeroes
        int[][] grid = new int[maxX][maxY];

        // Fill the grid with the line inputs
        fillGrid(grid, pointsList);

        // Calculate overlaps
        int overlaps = 0;
        for (int[] row: grid) {
            for (int col: row) {
                if (col > 1) {
                    overlaps += 1;
                }
            }
        }

        return overlaps;
    }

    /**
     * Utilizes the created list of arrays of tuples to fill the 2D integer array finding overlaps.
     * @param grid A 2D array of integer values that depict the number of times a point in pointslist crosses that point in a 2D plane.
     * @param pointsList A list of lines denoted by tuples which contain the start and end of the line.
     */
    private void fillGrid(int[][] grid, ArrayList<Pair<Integer, Integer>[]> pointsList) {
        // Iterate the lines in the list
        for (Pair<Integer, Integer>[] line: pointsList) {

            // X Values are the same so plot on grid via changing Y's
            if (line[0].getValue0().equals(line[1].getValue0())) {
                int xVal = line[0].getValue0();
                int minY = Math.min(line[0].getValue1(), line[1].getValue1());
                int maxY = Math.max(line[0].getValue1(), line[1].getValue1());
                for (int y = minY; y <= maxY; y++) {
                    grid[xVal][y] += 1;
                }
            }

            // Y Values are the same so plot on grid via changing X's
            else if (line[0].getValue1().equals(line[1].getValue1())) {
                int yVal = line[0].getValue1();
                int minX = Math.min(line[0].getValue0(), line[1].getValue0());
                int maxX = Math.max(line[0].getValue0(), line[1].getValue0());
                for (int x = minX; x <= maxX; x++) {
                    grid[x][yVal] += 1;
                }
            }

            // X and Y values share no commonalities, line is diagonal
            // Forcing start at smallest X value so X always increases and Y is variable
            else {
                Pair<Integer, Integer> start = line[0].getValue0() < line[1].getValue0() ? line[0] : line[1];
                Pair<Integer, Integer> end = line[0].getValue0() > line[1].getValue0() ? line[0] : line[1];
                int length = end.getValue0() - start.getValue0();

                for (int i = 0; i <= length; i++) {

                    // Starting Y > Ending Y
                    if (start.getValue1() > end.getValue1()) {
                        grid[start.getValue0() + i][start.getValue1() - i] += 1;
                    }
                    // Starting Y < Ending Y
                    else {
                        grid[start.getValue0() + i][start.getValue1() + i] += 1;
                    }
                }
            }
        }
    }

    /**
     * Calculates the maximum X value contained in the list of tuples.
     * @param pointsList A list of arrays with {start, end} tuples that have integer coordinates
     * @return An integer representing the maximum X value of all X values in the list
     */
    private int getValueXMax(ArrayList<Pair<Integer, Integer>[]> pointsList) {
        int max = Integer.MIN_VALUE;
        for (Pair<Integer,Integer>[] point: pointsList) {
            max = point[0].getValue0() > max ? point[0].getValue0() : max;
            max = point[1].getValue0() > max ? point[1].getValue0() : max;
        }
        return max;
    }

    /**
     * Calculates the maximum Y value contained in the list of tuples.
     * @param pointsList An list of arrays with {start, end} tuples that have integer coordinates
     * @return An integer representing the maximum Y value of all Y values in the list
     */
    private int getValueYMax(ArrayList<Pair<Integer, Integer>[]> pointsList) {
        int max = Integer.MIN_VALUE;
        for (Pair<Integer,Integer>[] point: pointsList) {
            max = point[0].getValue1() > max ? point[0].getValue1() : max;
            max = point[1].getValue1() > max ? point[1].getValue1() : max;
        }
        return max;
    }

    /**
     * Reads the file in the class and organizes it into a list of tuple arrays with start and end coordinates.
     *
     * @return A list of Integers from the inputted file
     */
    private ArrayList<Pair<Integer, Integer>[]> readFile() {
        File file = new File(filePath);
        var pointsList = new ArrayList<Pair<Integer, Integer>[]>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.length() != 0) {

                    // Parse the input and add to list
                    pointsList.add(parseLine(line));
                }
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
        return pointsList;
    }

    /**
     * Parses input lines in the form 'x1,y1 -> x2,y2` into tuple [start,end] arrays.
     *
     * @param line The current line in the input file that is being parsed for data
     * @return An array of {start, end} tuples that have integer coordinates for ease of manipulation
     */
    private Pair<Integer, Integer>[] parseLine(String line) {

        // Perform String Parsing
        String[] splitArrow = line.split("->", 2);
        String[] startStrings = splitArrow[0].trim().split(",", 2);
        String[] endStrings = splitArrow[1].trim().split(",", 2);

        // Store pairs in tuples and convert to integers
        Pair<Integer, Integer> start = new Pair<>(Integer.parseInt(startStrings[0]), Integer.parseInt(startStrings[1]));
        Pair<Integer, Integer> end = new Pair<>(Integer.parseInt(endStrings[0]), Integer.parseInt(endStrings[1]));

        return new Pair[]{start, end};
    }
}
