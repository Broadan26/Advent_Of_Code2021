package day_three;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day3PartTwo {

    private final Logger logger;
    private final String filePath;

    public Day3PartTwo() {
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_3";
        logger = LoggerFactory.getLogger(Day3PartTwo.class);
    }

    public Day3PartTwo(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day3PartTwo.class);
    }

    // MUY IMPORTANTE DEFINITIONS
    //-----------------------------------------------
    // Oxygen Generator Bit Criteria = Most common value in current bit position (Ties go to 1)
    // CO2 Scrubber Bit Criteria = Least common value in current bit position (Ties go to 0)

    /**
     * Calculates the gamma and epsilon rate of the bit input.
     *
     * @return An integer indicating the combination of gamma rate * epsilon rate (col * rows)
     */
    public Integer calculateBits() {
        var colBitList = readFile();
        if (!colBitList.isEmpty()) {
            // Parse Oxygen Rating
            int index = 0;
            var oxygenList = List.copyOf(colBitList);
            while(true) {
                // Determine the most common bit
                char mostCommon = mostCommonBit(oxygenList.get(index)) >= 0 ? '1' : '0';

                // Remove items from list not including most common bit
                oxygenList = removeRowItems(oxygenList, mostCommon, index);

                // Stop removing list items when 1 left
                if (oxygenList.get(0).length() == 1) {
                    break;
                } else if (oxygenList.get(0).length() == 0) {
                    return -1;
                }
                
                // Keep moving forward
                index += 1;
            }
            // Create Oxygen Rating Value
            StringBuilder oxygenBuilder = new StringBuilder();
            for(String col: oxygenList) {
                oxygenBuilder.append(col);
            }
            int oxygenValue = Integer.parseInt(oxygenBuilder.toString(), 2);

            // Parse CO2 Scrubber Rating
            index = 0;
            var co2List = List.copyOf(colBitList);
            while(true) {
                // Determine the most common bit
                char leastCommon = mostCommonBit(co2List.get(index)) >= 0 ? '0' : '1';

                // Remove items from list not including most common bit
                co2List = removeRowItems(co2List, leastCommon, index);

                // Stop removing list items when 1 left
                if (co2List.get(0).length() == 1) {
                    break;
                } else if (co2List.get(0).length() == 0) {
                    return -1;
                }

                // Keep moving forward
                index += 1;
            }
            // Create CO2 Scrubber Rating Value
            StringBuilder co2Builder = new StringBuilder();
            for(String col: co2List) {
                co2Builder.append(col);
            }
            int co2Value = Integer.parseInt(co2Builder.toString(), 2);

            // Calculate life support rating (multiply Oxygen by CO2)
            System.out.println("Oxygen: " + oxygenValue + "|| CO2: " + co2Value);
            return oxygenValue * co2Value;
        }
        return -1;
    }

    /**
     * Parses a list of bit columns into their respective rows and removes elements invalid elements.
     *
     * @param colList The column list needing to be pruned of invalid entries
     * @param numberToKeep The value which is used to determine which entries are invalid
     * @param currentCol The current column that is under consideration for validity
     * @return An updated column list with the elements that do not match the criteria removed from each row
     */
    private ArrayList<String> removeRowItems(List<String> colList, char numberToKeep, int currentCol) {
        // Create copy of original list
        ArrayList<String> newColList = new ArrayList<>();

        // Use StringBuilder to save time
        StringBuilder[] stringCols = new StringBuilder[colList.size()];
        for (int i = 0; i < colList.size(); i++) {
            stringCols[i] = new StringBuilder(colList.get(i));
        }

        // Remove items from rows
        int index = 0;
        while (index < stringCols[0].length()) {
            if (stringCols[currentCol].charAt(index) != numberToKeep) {
                for (StringBuilder stringCol : stringCols) {
                    stringCol.deleteCharAt(index);
                }
            } else {
                index += 1;
            }
        }

        // Rebuild the colList to return
        for (StringBuilder stringCol : stringCols) {
            newColList.add(stringCol.toString());
        }

        return newColList;
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
        var colBitList = new ArrayList<String>(); // Need to use for Oxygen/CO2

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
