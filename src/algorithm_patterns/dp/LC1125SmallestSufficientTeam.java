package algorithm_patterns.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1125SmallestSufficientTeam {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        Map<String, Integer> skillIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillIndex.put(req_skills[i], i);
        }
        int[] personMask = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            int mask = 0;
            for (String skill : people.get(i)) {
                int bit = skillIndex.get(skill);
                mask |= (1 << bit);
            }
            personMask[i] = mask;
        }
        int totalMasks = 1 << n;
        List<Integer>[] dp = new List[totalMasks];
        dp[0] = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            int skillMask = personMask[i];
            for (int mask = 0; mask < totalMasks; mask++) {
                if (dp[mask] == null) {
                    continue;
                }
                int newMask = mask | skillMask;
                if (dp[newMask] == null ||
                        dp[newMask].size() > dp[mask].size() + 1) {
                    List<Integer> newTeam =
                            new ArrayList<>(dp[mask]);
                    newTeam.add(i);
                    dp[newMask] = newTeam;
                }
            }
        }
        return dp[totalMasks - 1]
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
