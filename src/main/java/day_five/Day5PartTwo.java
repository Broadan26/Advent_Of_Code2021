package day_five;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
