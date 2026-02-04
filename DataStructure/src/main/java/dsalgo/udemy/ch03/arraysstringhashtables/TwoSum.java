package dsalgo.udemy.ch03.arraysstringhashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * Dado un array de numeros enteros y un targte, retorn los indices
 * de los nummeros para los que la suma de ambos sea igual al target
 *
 * Podemos asumur que solo hay una solucion
 * Ejemplo 1:
 * Input nums = [9,2,5,6], tarhet = 7
 * Output: [1,2]
 *
 * Ejemplo: 2
 * Input nums: [9,2,5,6], taget = 100;
 * Output: null
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target){
        if (nums == null || nums.length <2) return null;

        Map<Integer, Integer> compMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            // verifica si el elemento esta presente en el mapa de complementos
            if (compMap.containsKey(nums[i]))
                return new int[]{i, compMap.get(nums[i])};

            int complement = target - nums[i];

        }
        return null;
    }
}
