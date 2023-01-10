package day_fourteen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class Day14PartOne {

    private final Logger logger;
    private final String filePath;

    public Day14PartOne() {
        logger = LoggerFactory.getLogger(Day14PartOne.class);
        this.filePath = System.getProperty("user.dir") + "\\Input\\input_day_14";
    }

    public Day14PartOne(String filePath) {
        logger = LoggerFactory.getLogger(Day14PartOne.class);
        this.filePath = filePath;
    }

    /**
     * Utilizes the input file to modify a given template based on the provided grammar rules.
     * Performs alterations to the template and returns an integer detailing the difference in alphabetic letters.
     * @return An integer representing the difference between the most common alphabetic letter and the least common
     */
    public int calculate() {
        // Get template string and grammar rules from file input
        var template = getTemplate();
        var grammarRules = getGrammarRules();

        // Modify template using grammar rules
        int steps = 10;
        var modifiedTemplate = modifyTemplate(template, grammarRules, steps);

        // Calculate the difference in most and least common characters
        // Return the value
        return differenceOfMostAndLeast(modifiedTemplate);
    }

    /**
     * Finds the most and least common characters in the modifiedTemplate string. Then returns the difference of those two values.
     * @param modifiedTemplate The modified template string to count character values for
     * @return An integer value representing the difference between the most common and least common characters in the modified template
     */
    private int differenceOfMostAndLeast(String modifiedTemplate) {
        // Easy way to count characters
        var characterCount = new HashMap<Character, Integer>();
        for (int ch = 0; ch < modifiedTemplate.length(); ch++) {
            if (characterCount.containsKey(modifiedTemplate.charAt(ch))) {
                int oldValue = characterCount.get(modifiedTemplate.charAt(ch));
                characterCount.replace(modifiedTemplate.charAt(ch), oldValue+1);
            } else {
                characterCount.put(modifiedTemplate.charAt(ch), 1);
            }
        }
        // Find most and least
        int most = Integer.MIN_VALUE;
        int least = Integer.MAX_VALUE;
        for (var key : characterCount.keySet()) {
            // Alter most
            if (characterCount.get(key) > most) {
                most = characterCount.get(key);
            }
            // Alter least
            if (characterCount.get(key) < least) {
                least = characterCount.get(key);
            }
        }

        return most - least;
    }

    /**
     * Simulates a set of grammar rules being applied to a template string n times and returns the modified string.
     * @param template The original string that is modified based on the grammarRules
     * @param grammarRules The rules that determine how the template string is modified each step
     * @param steps The number of times the grammarRules should be applied to the template
     * @return The modified string after n steps are taken and applying the grammarRules each time
     */
    private String modifyTemplate(String template, HashMap<String, String> grammarRules, int steps) {
        // Convert template string to string builder for faster alterations
        StringBuilder templateRebuild = new StringBuilder(template);

        // Perform all n steps
        while (steps > 0) {
            // Modify the template string based on grammar rules
            int index = 0;
            while(index < templateRebuild.length()-1) {
                String substring = templateRebuild.substring(index, index+2);
                // Grammar Rule can be used
                if (grammarRules.containsKey(substring)) {
                    templateRebuild.insert(index+1, grammarRules.get(substring));
                    index++;
                }
                index++;
            }
            steps--;
        }

        return templateRebuild.toString();
    }

    /**
     * Collects the grammar rules from the input file.
     * @return A hashmap containing the grammar to find and the grammar to insert
     */
    private HashMap<String, String> getGrammarRules() {
        var grammarRules = new HashMap<String, String>();
        File file = new File(filePath);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Skip empty lines or template lines
                if (!line.contains("->")) {
                    continue;
                }
                // Split and massage rules
                String[] rule = line.split("->", 2);
                grammarRules.put(rule[0].trim(), rule[1].trim());
            }
        } catch (Exception ex) {
            logger.info(ex.toString());
        }

        return grammarRules;
    }

    /**
     * Collects the string template from the input file.
     * @return The template to be utilized and modified in string format
     */
    private String getTemplate() {
        String template = "";
        File file = new File(filePath);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            // Template should always be on the top line
            template = bufferedReader.readLine();
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
        return template;
    }
}
