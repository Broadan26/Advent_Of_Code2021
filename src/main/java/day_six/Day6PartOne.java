package day_six;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
