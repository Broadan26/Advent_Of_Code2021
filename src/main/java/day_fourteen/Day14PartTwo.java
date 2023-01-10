package day_fourteen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day14PartTwo {

    private final Logger logger;
    private final String filePath;

    public Day14PartTwo() {
        logger = LoggerFactory.getLogger(Day14PartTwo.class);
        this.filePath = System.getProperty("user.dir") + "\\Input\\input_day_14";
    }

    public Day14PartTwo(String filePath) {
        logger = LoggerFactory.getLogger(Day14PartTwo.class);
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