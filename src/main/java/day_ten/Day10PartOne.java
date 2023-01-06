package day_ten;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.HashMap;

public class Day10PartOne {

    private final Logger logger;
    private final String filePath;
    private final HashMap<Character, Character> bracePairs = new HashMap<>() {{
        put('(', ')');
        put('[', ']');
        put('{', '}');
        put('<', '>');
    }};
    private final HashMap<Character, Integer> syntaxScoreMap = new HashMap<>() {{
        put(')', 3);
        put(']', 57);
        put('}', 1197);
        put('>', 25137);
    }};

    public Day10PartOne() {
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_10";
        logger = LoggerFactory.getLogger(Day10PartOne.class);
    }

    public Day10PartOne(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day10PartOne.class);
    }

    /**
     * Calculates the total score of syntax errors based on the initialized syntaxScoreMap
     * @return An integer representing the sum of all the syntax scores in the imported file
     */
    public int calculateSyntaxErrors() {
        return readFile();
    }

    /**
     * Reads the input file and while parsing calculates the syntax error score of the input file
     * @return An integer representing the sum of all the syntax scores in the imported file
     */
    private int readFile() {
        File file = new File(filePath);
        var stack = new ArrayDeque<Character>();
        int syntaxErrorScore = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
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
                            syntaxErrorScore += syntaxScoreMap.get(line.charAt(i));
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
        return syntaxErrorScore;
    }
}
