package day_eight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Day8PartOne {

    private final Logger logger;
    private final String filePath;

    public Day8PartOne() {
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_8";
        logger = LoggerFactory.getLogger(Day8PartOne.class);
    }

    public Day8PartOne(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day8PartOne.class);
    }
}
