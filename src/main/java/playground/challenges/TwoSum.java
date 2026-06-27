package playground.challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * Desafio: Two Sum (LeetCode #1)
 * 
 * Dado um vetor de inteiros nums e um inteiro target, retorne os índices dos dois números
 * de forma que a soma deles seja igual a target.
 * 
 * Complexidade de Tempo: O(n) utilizando uma tabela Hash.
 * Complexidade de Espaço: O(n).
 */
public class TwoSum {
    
    public int[] solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("Nenhuma solução encontrada");
    }
}
