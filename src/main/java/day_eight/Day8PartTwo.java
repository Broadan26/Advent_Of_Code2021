package day_eight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Day8PartTwo {

    private final Logger logger;
    private final String filePath;

    public Day8PartTwo() {
        this.filePath = "Input/input_day_8";
        logger = LoggerFactory.getLogger(Day8PartTwo.class);
    }

    public Day8PartTwo(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day8PartTwo.class);
    }
}
