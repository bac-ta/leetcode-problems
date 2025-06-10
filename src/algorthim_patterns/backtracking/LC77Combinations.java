package algorthim_patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        int start = 1;
        List<List<Integer>> results = new ArrayList<>();
        backtrack(start, results, new ArrayList<>(), n, k);
        return results;
    }

    private void backtrack(int start, List<List<Integer>> results, List<Integer> paths, int n, int k) {
        if (paths.size() ==k){
            results.add(new ArrayList<>(paths));
            return;
        }

        for (int i = start; i <= n; i++) {
            paths.add(i);
            backtrack(i+1, results, paths, n, k);
            paths.removeLast(); // paths.remove(path.size() -1);
        }
    }
}
