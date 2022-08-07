package day_seven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Day7PartTwo {

    private final Logger logger;
    private final String filePath;

    public Day7PartTwo() {
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_7";
        logger = LoggerFactory.getLogger(Day7PartTwo.class);
    }

    public Day7PartTwo(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day7PartTwo.class);
    }
}
