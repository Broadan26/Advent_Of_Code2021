package day_ten;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
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
    private final HashMap<Character, Integer> braceScoreMap = new HashMap<>() {{
        put(')', 1);
        put(']', 2);
        put('}', 3);
        put('>', 4);
    }};

    public Day10PartTwo() {
        this.filePath = "D:\\Projects\\AdventOfCode2021\\Input\\input_day_10";
        logger = LoggerFactory.getLogger(Day10PartTwo.class);
    }

    public Day10PartTwo(String filePath) {
        this.filePath = filePath;
        logger = LoggerFactory.getLogger(Day10PartTwo.class);
    }

    /**
     * Reads the input file and finds the median score of the incomplete brace pairs based on a given map formula
     * @return The median score of the incomplete brace pairs
     */
    public long calculateIncomplete() {
        // Read the file and organize into incomplete stacks
        var stackList = readFile();

        // Create a list of scores based on incomplete stacks
        var scoreList = calculateLineScores(stackList);

        // Sort the list of scores
        scoreList.sort(Comparator.naturalOrder());

        // Return the median score
        return scoreList.get(scoreList.size() / 2);
    }

    /**
     * Calculates the score required to complete the incomplete stacks
     * @param stackList The list of all the stacks needing a score
     * @return A list of the scores for every stack in the stacklist
     */
    private ArrayList<Long> calculateLineScores(ArrayList<ArrayDeque<Character>> stackList) {
        var scoreList = new ArrayList<Long>();

        for (var stack : stackList) {
            long currentScore = 0;
            while (!stack.isEmpty()) {
                // Score Formula: currentScore * 5 + braceScore
                currentScore = (currentScore * 5) + braceScoreMap.get(bracePairs.get(stack.pop()));
            }
            scoreList.add(currentScore);
        }
        return scoreList;
    }

    /**
     * Reads the input file and while parsing looks for incomplete stacks
     * @return A list of all the incomplete stacks and what remains in those incomplete stacks
     */
    private ArrayList<ArrayDeque<Character>> readFile() {
        File file = new File(filePath);
        var stackList = new ArrayList<ArrayDeque<Character>>();

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
                        // Dump the stack as it's useless and break out of the loop
                        if (stack.isEmpty() || bracePairs.get(stack.pop()) != line.charAt(i)) {
                            stack.clear();
                            break;
                        }
                        // Something went wrong
                    } else {
                        throw new Exception("Invalid opening/closing character in file");
                    }
                }

                // If the stack is just incomplete, add it to the stackList for later usage
                if (!stack.isEmpty()) {
                    stackList.add(stack);
                }
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
        return stackList;
    }
}
