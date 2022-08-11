package day_eight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day8PartTwoTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day8PartTwo day8 = new Day8PartTwo("Input/input_day_8_small");
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day8PartTwo day8 = new Day8PartTwo("Input/input_day_8_medium");
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day8PartTwo day8 = new Day8PartTwo();
    }
}
