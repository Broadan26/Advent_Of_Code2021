package day_thirteen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day13PartTwo {

    private final Logger logger;
    private final String filePath;

    public Day13PartTwo() {
        this.filePath = System.getProperty("user.dir") + "\\Input\\input_day_13";
        logger = LoggerFactory.getLogger(Day13PartTwo.class);
    }

    public Day13PartTwo(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day13PartTwo.class);
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