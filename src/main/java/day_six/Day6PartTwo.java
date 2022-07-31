package day_six;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Day6PartTwo {

    private final Logger logger;
    private final String filePath;

    public Day6PartTwo() {
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_6";
        logger = LoggerFactory.getLogger(Day6PartTwo.class);
    }

    public Day6PartTwo(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day6PartTwo.class);
    }
}
