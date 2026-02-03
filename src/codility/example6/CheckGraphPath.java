package codility.example6;

import java.util.HashSet;
import java.util.Set;

public class CheckGraphPath {
    public boolean solution(int N, int[] A, int[] B) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            int u = A[i];
            int v = B[i];
            set.add(u + "#" + v);
            set.add(v + "#" + u);
        }

        for (int i = 1; i < N; i++) {
            String need = i + "#" + (i + 1);
            if (!set.contains(need)) {
                return false;
            }
        }

        return true;
    }
}
