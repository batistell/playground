package playground.challenges;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TwoSumTest {
    
    private final TwoSum solver = new TwoSum();
    
    @Test
    public void testTwoSum_StandardCase() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        assertArrayEquals(expected, solver.solve(nums, target));
    }
    
    @Test
    public void testTwoSum_AnotherCase() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {1, 2};
        assertArrayEquals(expected, solver.solve(nums, target));
    }
    
    @Test
    public void testTwoSum_SameElements() {
        int[] nums = {3, 3};
        int target = 6;
        int[] expected = {0, 1};
        assertArrayEquals(expected, solver.solve(nums, target));
    }
    
    @Test
    public void testTwoSum_NoSolution() {
        int[] nums = {1, 2, 3};
        int target = 7;
        assertThrows(IllegalArgumentException.class, () -> solver.solve(nums, target));
    }
}
