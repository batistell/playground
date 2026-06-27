package playground.challenges;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("AD01 - Two Sum")
public class TwoSumTest {
    
    private final TwoSum solver = new TwoSum();
    
    @Test
    @DisplayName("Caso 1: Encontrar índices para soma padrão (2, 7) = 9")
    public void testTwoSum_StandardCase() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        assertArrayEquals(expected, solver.solve(nums, target));
    }
    
    @Test
    @DisplayName("Caso 2: Encontrar índices em outro caso (2, 4) = 6")
    public void testTwoSum_AnotherCase() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {1, 2};
        assertArrayEquals(expected, solver.solve(nums, target));
    }
    
    @Test
    @DisplayName("Caso 3: Encontrar índices com elementos idênticos (3, 3) = 6")
    public void testTwoSum_SameElements() {
        int[] nums = {3, 3};
        int target = 6;
        int[] expected = {0, 1};
        assertArrayEquals(expected, solver.solve(nums, target));
    }
    
    @Test
    @DisplayName("Caso 4: Lançar exceção se não houver soma possível")
    public void testTwoSum_NoSolution() {
        int[] nums = {1, 2, 3};
        int target = 7;
        assertThrows(IllegalArgumentException.class, () -> solver.solve(nums, target));
    }
}
