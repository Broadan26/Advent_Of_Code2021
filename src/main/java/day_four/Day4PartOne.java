package day_four;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Day4PartOne {

    private final Logger logger;
    private final String filePath;

    public Day4PartOne() {
        logger = LoggerFactory.getLogger(Day4PartOne.class);
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_4";
    }

    public Day4PartOne(String filePath) {
        logger = LoggerFactory.getLogger(Day4PartOne.class);
        this.filePath = filePath;
    }

    /**
     * Function that effectively controls the BINGO simulation of Day 4 for ease of use.
     *
     * @return An integer representing the sum of the remaining numbers of the winning BINGO board * the last number called out
     */
    public int calculateBestBoard() {
        // Read the file
        var parsedList = readFile();

        // Get the bingo inputs
        var numbers = parseNumbers(parsedList.get(0));

        // Get board rows
        var allBoardRows = new ArrayList<HashSet<Integer>[]>();
        for (int i = 1; i < parsedList.size(); i+= 5) {
            allBoardRows.add(parseBoardRows(parsedList.subList(i, i+5)));
        }

        // Get board columns
        var allBoardColumns = new ArrayList<HashSet<Integer>[]>();
        for (int i = 1; i < parsedList.size(); i += 5) {
            allBoardColumns.add(parseBoardCols(parsedList.subList(i, i+5)));
        }

        // Determine winning board
        return playBingo(allBoardRows, allBoardColumns, numbers);
    }

    /**
     * Simulates a game of BINGO and selects the winning board from the group of all boards
     *
     * @param allBoardRows A list of boards with hashsets substituting for their physical rows
     * @param allBoardColumns A list of boards with hashsets substituting for their physical columns
     * @param numbers The list of numbers called out in a game of BINGO
     * @return An integer representing the sum of the remaining numbers of the winning BINGO board * the last number called out. An invalid integer -1 if no winners.
     */
    private int playBingo(ArrayList<HashSet<Integer>[]> allBoardRows, ArrayList<HashSet<Integer>[]> allBoardColumns, ArrayList<Integer> numbers) {

        // Iterate by called out numbers
        for (int number: numbers) {

            // Iterate by boards
            for (int board = 0; board < allBoardRows.size(); board++) {

                // Iterate by rows
                for (HashSet<Integer> row: allBoardRows.get(board)) {
                    row.remove(number);
                    // Calculate winning board score
                    if (row.isEmpty()) {
                        return number * calculateBoardScore(allBoardColumns.get(board));
                    }
                }

                // Iterate by columns
                for (HashSet<Integer> col: allBoardColumns.get(board)) {
                    col.remove(number);
                    // Calculate winning board score
                    if (col.isEmpty()) {
                        return number * calculateBoardScore(allBoardColumns.get(board));
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Calculates the score of a board by summing up all remaining items in its columns
     * @param rowCol The array of hashsets representing a BINGO boards remaining values
     * @return An integer representing the score of the board as a summation
     */
    private int calculateBoardScore(HashSet<Integer>[] rowCol) {
        int sum = 0;
        // Calculate col sum
        for (HashSet<Integer> col: rowCol) {
            sum += col.stream().mapToInt(Integer::intValue).sum();
        }

        return sum;
    }

    /**
     * Parses a 5x5 Bingo board by its columns.
     *
     * @param board The list of numbers that make up a 5x5 Bingo board
     * @return A list of hashsets that contain the numbers in each board by column
     */
    private HashSet<Integer>[] parseBoardCols(List<String> board) {
        // Setup hashset to quickly perform number comparisons and use built-in functions
        HashSet<Integer>[] boardCols = new HashSet[5];
        for (int i = 0; i < boardCols.length; i++) {
            boardCols[i] = new HashSet<>();
        }

        // Split the row by its spaces
        for (String line: board) {
            String[] split = line.split(" ");

            // Convert each String to an int and store in appropriate column hashset
            int offset = 0;
            for (int i = 0; i < split.length; i++) {
                if (split[i].length() != 0) {
                    boardCols[i-offset].add(Integer.parseInt(split[i]));
                } else { // Keep running offset for bad splits in input
                    offset += 1;
                }
            }
        }
        return boardCols;
    }

    /**
     * Parses a 5x5 Bingo board by its rows.
     *
     * @param board The list of numbers that make up a 5x5 Bingo board
     * @return A list of hashsets that contain the numbers in each board by row
     */
    private HashSet<Integer>[] parseBoardRows(List<String> board) {
        // Setup hashset to quickly perform number comparisons and use built-in functions
        HashSet<Integer>[] boardRows = new HashSet[5];

        // Split the row by its spaces
        for (int i = 0; i < board.size(); i++) {
            HashSet<Integer> row = new HashSet<>();
            String[] split = board.get(i).split(" ");

            // Convert each string number into an int and store in hashset
            for (String num: split) {
                if (num.length() != 0) {
                    row.add(Integer.parseInt(num));
                }
            }
            boardRows[i] = row;
        }
        return boardRows;
    }

    /**
     * Dedicated method for splitting the inputs line in the day 4 inputs file.
     *
     * @param line The line from the read file to be split
     * @return An array of Integers each with a single numeric value
     */
    private ArrayList<Integer> parseNumbers(String line) {
        String[] numbers = line.split(",");
        var intNumbers = new ArrayList<Integer>();
        for (String num: numbers) {
            intNumbers.add(Integer.parseInt(num));
        }
        return intNumbers;
    }

    /**
     * Reads the file in the class and organizes into a list of Strings
     *
     * @return A list of Strings from the inputted file
     */
    private ArrayList<String> readFile() {
        File file = new File(filePath);
        var docList = new ArrayList<String>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.length() != 0) {
                    docList.add(line);
                }
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
        return docList;
    }
}
