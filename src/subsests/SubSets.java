package subsests;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<>());

        for (Integer num : nums) {
            List<List<Integer>> newSubsets =  new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<>(curr) {{
                    add(num);
                }});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        var instance = new SubSets();
        int[] nums = {1, 2, 3};
        var results = instance.subsets(nums);
        System.out.println(results);
    }
}
