package day_fourteen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

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

    /**
     * Utilizes the input file to modify a given template based on the provided grammar rules.
     * Performs alterations to the template and returns an integer detailing the difference in alphabetic letters.
     * @return An integer representing the difference between the most common alphabetic letter and the least common
     */
    public long calculate() {
        // Get template string and grammar rules from file input
        var template = getTemplate();
        var grammarRules = getGrammarRules();

        // Modify template using grammar rules
        int steps = 40;
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
    private long differenceOfMostAndLeast(HashMap<String, Long> modifiedTemplate) {
        // Separate each pair into its constituent elements for counting
        var countCharacters = new HashMap<Character, Long>();
        for (var key : modifiedTemplate.keySet()) {
            // Get the first character
            if (countCharacters.containsKey(key.charAt(0))) {
                long temp = countCharacters.get(key.charAt(0)) + modifiedTemplate.get(key);
                countCharacters.replace(key.charAt(0), temp);
            } else {
                countCharacters.put(key.charAt(0), modifiedTemplate.get(key));
            }
            // Get the second character
            if (countCharacters.containsKey(key.charAt(1))) {
                long temp = countCharacters.get(key.charAt(1)) + modifiedTemplate.get(key);
                countCharacters.replace(key.charAt(1), temp);
            } else {
                countCharacters.put(key.charAt(0), modifiedTemplate.get(key));
            }
        }
        System.out.println(countCharacters);

        // Find most and least
        long most = Long.MIN_VALUE;
        long least = Long.MAX_VALUE;
        for (var key : countCharacters.keySet()) {
            // Alter most
            if (countCharacters.get(key) > most) {
                most = countCharacters.get(key);
            }
            // Alter least
            if (countCharacters.get(key) < least) {
                least = countCharacters.get(key);
            }
        }
        System.out.println(most);
        System.out.println(least);
        return most - least;
    }

    /**
     * Simulates a set of grammar rules being applied to a template string n times and returns the modified string.
     * @param template The original string that is modified based on the grammarRules
     * @param grammarRules The rules that determine how the template string is modified each step
     * @param steps The number of times the grammarRules should be applied to the template
     * @return The modified string after n steps are taken and applying the grammarRules each time
     */
    private HashMap<String, Long> modifyTemplate(String template, HashMap<String, String> grammarRules, int steps) {
        // Convert the template into a hashmap since Strings by themselves won't work for huge steps
        var templateRebuild = new HashMap<String, Long>();
        for (int i = 0; i < template.length()-1; i++) {
            String subString = template.substring(i, i+2);
            if (templateRebuild.containsKey(subString)) {
                long subStringCount = templateRebuild.get(subString);
                templateRebuild.replace(subString, subStringCount+1);
            } else {
                templateRebuild.put(subString, 1L);
            }
        }
        System.out.println(templateRebuild);

        // Perform all n steps
        while (steps > 0) {
            // Temporary hashmap for updating rebuildTemplate
            var updatedTemplate = new HashMap<String, Long>();
            // Modify the template string based on grammar rules
            for (var key : templateRebuild.keySet()) {
                // Expand the first half
                if (updatedTemplate.containsKey(key.charAt(0) + grammarRules.get(key))) {
                    long temp = updatedTemplate.get(key.charAt(0) + grammarRules.get(key)) + templateRebuild.get(key);
                    updatedTemplate.replace(key.charAt(0) + grammarRules.get(key), temp);
                } else {
                    updatedTemplate.put(key.charAt(0) + grammarRules.get(key), templateRebuild.get(key));
                }
                // Expand the second half
                if (updatedTemplate.containsKey(grammarRules.get(key) + key.charAt(1))) {
                    long temp = updatedTemplate.get(grammarRules.get(key) + key.charAt(1)) + templateRebuild.get(key);
                    updatedTemplate.replace(grammarRules.get(key) + key.charAt(1), temp);
                } else {
                    updatedTemplate.put(grammarRules.get(key) + key.charAt(1), templateRebuild.get(key));
                }
            }
            templateRebuild = updatedTemplate;
            steps--;
        }
        return templateRebuild;
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
