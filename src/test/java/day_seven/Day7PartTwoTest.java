package day_seven;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day7PartTwoTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day7PartTwo day7 = new Day7PartTwo("Input/input_day_7_small");
        assertEquals(168, day7.calculateFuelCost());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day7PartTwo day7 = new Day7PartTwo("Input/input_day_7_medium");
        assertEquals(2671360, day7.calculateFuelCost());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day7PartTwo day7 = new Day7PartTwo();
        assertEquals(91257582, day7.calculateFuelCost());
    }
}
