package day_four;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Day4PartTwo {

    private final Logger logger;
    private final String filePath;

    public Day4PartTwo() {
        logger = LoggerFactory.getLogger(Day4PartTwo.class);
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_4";
    }

    public Day4PartTwo(String filePath) {
        logger = LoggerFactory.getLogger(Day4PartTwo.class);
        this.filePath = filePath;
    }
}
