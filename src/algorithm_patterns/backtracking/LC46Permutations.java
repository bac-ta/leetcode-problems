package algorithm_patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(results, new ArrayList<>(), nums, used);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> paths, int[] nums, boolean[] used) {
        if (paths.size() == nums.length) {
            results.add(new ArrayList<>(paths));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            paths.add(nums[i]);
            used[i] = true;
            backtrack(results, paths, nums, used);
            paths.removeLast();
            used[i] = false;
        }
    }
}
