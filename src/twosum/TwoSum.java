package twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] numbers, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int element = numbers[i];
            if (map.containsKey(sum - element)) {
                //return to index of array
                return new int[]{map.get(sum - element), i};
            }
            //Else put to map
            map.put(element, i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, -1, -7, -100, -43};
        int sum = -8;
        int[] result = new TwoSum().twoSum(numbers, sum);
        if (result.length > 0) {
            System.out.println(result[0]);
            System.out.println(result[1]);
        }
    }
}
