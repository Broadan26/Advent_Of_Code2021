package day_fifteen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day15PartOne {

    private final Logger logger;
    private final String filePath;

    public Day15PartOne() {
        logger = LoggerFactory.getLogger(Day15PartOne.class);
        this.filePath = System.getProperty("user.dir") + "\\Input\\input_day_15";
    }

    public Day15PartOne(String filePath) {
        logger = LoggerFactory.getLogger(Day15PartOne.class);
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
