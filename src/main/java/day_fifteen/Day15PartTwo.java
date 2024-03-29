package day_fifteen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day15PartTwo {

    private final Logger logger;
    private final String filePath;

    public Day15PartTwo() {
        logger = LoggerFactory.getLogger(Day15PartTwo.class);
        this.filePath = System.getProperty("user.dir") + "\\Input\\input_day_15";
    }

    public Day15PartTwo(String filePath) {
        logger = LoggerFactory.getLogger(Day15PartTwo.class);
        this.filePath = filePath;
    }

    public int calculate() {
        readFile();

        return -1;
    }

    private void readFile() {
        File file = new File(filePath);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                logger.info(line);
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
    }
}
