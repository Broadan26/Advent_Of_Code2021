package day_nine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day9PartOne {

    private final Logger logger;
    private final String filePath;

    public Day9PartOne() {
        logger = LoggerFactory.getLogger(Day9PartOne.class);
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_9";
    }

    public Day9PartOne(String filePath) {
        logger = LoggerFactory.getLogger(Day9PartOne.class);
        this.filePath = filePath;
    }

    /**
     * Reads the class file and determines the lowest points and the total risk associated with all the lowest points.
     * @return An integer value representing the total risk of all the lowest points
     */
    public int calculateRiskOfLowestPoint() {
        return -1;
    }
}
