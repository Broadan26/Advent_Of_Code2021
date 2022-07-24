package day_two;

import day_two.entity.Direction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day2PartOne {

    private final Logger logger;
    private final String filePath;

    public Day2PartOne() {
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_2";
        logger = LoggerFactory.getLogger(Day2PartOne.class);
    }

    public Day2PartOne(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day2PartOne.class);
    }

    /**
     * Calculates the position of the object given in the inputted file.
     * Assumes the object starts at horizontal position 0 and depth 0.
     *
     * @return The position when horizontal position is multiplied by the depth
     */
    public int calculatePosition() {
        var directionsList = this.readFile();

        // Calculate position
        int depth = 0;
        int horizontal = 0;
        if (!directionsList.isEmpty()) {
            for (Direction direction : directionsList) {
                switch (direction.getDirection()) {
                    case "forward" -> horizontal += direction.getDegree();
                    case "up" -> depth -= direction.getDegree();
                    case "down" -> depth += direction.getDegree();
                    default -> depth += 0;
                }
            }
        }

        return depth * horizontal;
    }

    /**
     * Reads the file in the class and organizes into a list of:
     * A) Directions
     * B) Degree of direction
     *
     * @return A list of integers from the inputted file
     */
    private ArrayList<Direction> readFile() {
        File file = new File(filePath);
        var directionsList = new ArrayList<Direction>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(" ");
                String direction = split[0];
                Integer degree = Integer.parseInt(split[1]);

                directionsList.add(new Direction(direction, degree));
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }

        return directionsList;
    }
}
