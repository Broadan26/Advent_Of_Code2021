package day_ten;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.HashMap;

public class Day10PartTwo {

    private final Logger logger;
    private final String filePath;
    private final HashMap<Character, Character> bracePairs = new HashMap<>() {{
        put('(', ')');
        put('[', ']');
        put('{', '}');
        put('<', '>');
    }};

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

    /**
     * Reads the input file and while parsing calculates the syntax error score of the input file
     * @return An integer representing the sum of all the syntax scores in the imported file
     */
    private void readFile() {
        File file = new File(filePath);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                var stack = new ArrayDeque<Character>();

                for (int i = 0; i < line.length(); i++) {
                    // Check if character is an opening brace
                    if (bracePairs.containsKey(line.charAt(i))) {
                        stack.addFirst(line.charAt(i));
                        // Check if value is a closing brace
                    } else if (bracePairs.containsValue(line.charAt(i))) {
                        // If stack is empty, invalid closing brace was found
                        // If the closing brace does not match the opening brace, then invalid closing brace found
                        // Add the value of that invalid closing brace to syntax error score
                        if (stack.isEmpty() || bracePairs.get(stack.pop()) != line.charAt(i)) {

                        }
                        // Something went wrong
                    } else {
                        throw new Exception("Invalid opening/closing character in file");
                    }
                }
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
    }
}
