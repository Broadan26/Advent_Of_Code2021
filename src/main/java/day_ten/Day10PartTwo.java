package day_ten;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day10PartTwo {

    private final Logger logger;
    private final String filePath;

    public Day10PartTwo() {
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_10";
        logger = LoggerFactory.getLogger(Day10PartTwo.class);
    }

    public Day10PartTwo(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day10PartTwo.class);
    }

    public int calculateSyntaxErrors() {
        readFile();

        return -1;
    }

    private void readFile() {
        File file = new File(filePath);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                logger.info(line);
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
    }
}
