package single_number;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public int singleNumberByXor(int[] A) {
        int num = 0;
        for (int x : A) {
            num ^= x;
        }
        return num;
    }
    public int singleNumberBySet(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int x : A) {
            if (set.contains(x)) {
                set.remove(x);
            } else {
                set.add(x);
            }
        }
        return set.iterator().next();
    }
}
