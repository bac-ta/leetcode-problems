package algorithm_patterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solutions {
    public int solution(String P, String Q) {
        // Implement your solution here
        List<String> combinations = new ArrayList<>();
        doBackTracking(combinations,"", new StringBuilder(P).append(Q).toString(), P.length());

        Map<String, Integer> frequenceMap = new HashMap<>();

        Set<Character> set;

        for (String comb: combinations) {
            char []characters = comb.toCharArray();
            set = new HashSet<>();
            for (char c: characters){

                set.add(c);
            }

            frequenceMap.put(comb, set.size());
        }

        return Collections.min(frequenceMap.values());

    }

    private void doBackTracking(List<String> combinations, String path, String pq, int n){
        if (path.length()==n){
            combinations.add(path);
            return;
        }

        for (int i =0; i < pq.toCharArray().length; i++){
            path = path + pq.charAt(i);
            doBackTracking(combinations, path, pq, n);
            path = path.substring(0, path.length() - 1);
        }
    }
}
