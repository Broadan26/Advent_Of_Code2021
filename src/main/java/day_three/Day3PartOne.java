package day_three;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day3PartOne {

    private final Logger logger;
    private final String filePath;

    public Day3PartOne() {
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_3";
        logger = LoggerFactory.getLogger(Day3PartOne.class);
    }

    public Day3PartOne(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day3PartOne.class);
    }

    // MUY IMPORTANTE DEFINITIONS
    //-----------------------------------------------
    // Gamma Rate = The most common bit of each column
    // Epsilon Rate = The least common bit of each column

    /**
     * Calculates the gamma and epsilon rate of the bit input.
     *
     * @return An integer indicating the combination of gamma rate * epsilon rate (col * rows)
     */
    public Integer calculateBits() {
        var colBitList = readFile();
        if (!colBitList.isEmpty()) {

            // Create the final bit string from input file
            StringBuilder gammaNumber = new StringBuilder();
            for (String col: colBitList) {
                gammaNumber.append(mostCommonBit(col) > 0 ? 1 : 0); // Append 0 or 1 depending on bit commonality
            }

            // Calculate Gamma Rate
            int gammaRate = Integer.parseInt(gammaNumber.toString(), 2);

            // Calculate Epsilon Rate
            StringBuilder epsilonNumber = new StringBuilder();
            for (int i = 0; i < gammaNumber.length(); i++) {
                epsilonNumber.append(gammaNumber.charAt(i) == '0' ? '1' : '0');
            }
            int epsilonRate = Integer.parseInt(epsilonNumber.toString(), 2);

            // Return multiplication
            return gammaRate * epsilonRate;
        }
        return -1;
    }

    /**
     * Calculates the most common bit in the given string list of bits.
     *
     * @param bitList A string of bits (0's and 1's)
     * @return A positive number if the number of bits is positive. A negative number if number of bits is negative. 0 if bits are equal.
     */
    private int mostCommonBit(String bitList) {
        int count = 0;
        for (int i = 0; i < bitList.length(); i++) {
            if (bitList.charAt(i) == '0') {
                count -= 1;
            } else {
                count += 1;
            }
        }
        return count;
    }

    /**
     * Reads the file in the class and organizes into two lists of:
     * A) Column bits
     * B) Row bits
     *
     * @return A list of bit strings from the inputted file
     */
    private ArrayList<String> readFile() {
        File file = new File(filePath);
        var rowBitList = new ArrayList<String>(); // Not used outside of function
        var colBitList = new ArrayList<String>(); // Need to use for gamma/epsilon

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            // Collect the row bit list
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                rowBitList.add(line);
            }

            // If file not read properly throw an exception to break execution
            if (rowBitList.isEmpty()) {
                throw new Exception("Invalid input file");
            }

            // Collect the column bit list
            for (int i = 0; i < rowBitList.get(0).length(); i++) {
                StringBuilder col = new StringBuilder();
                for (String row : rowBitList) {
                    col.append(row.charAt(i));
                }
                colBitList.add(col.toString());
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
        return colBitList;
    }
}
