package plusone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public void plusOne(List<Integer> digits) {
        for (int i = digits.size() - 1; i >= 0; i--) {
            int digit = digits.get(i);
            if (digit < 9) {
                digits.set(i, digit + 1);
                return;
            } else {
                digits.set(i, 0);
            }
        }
        digits.add(0);
        digits.set(0, 1);
    }

    public static void main(String[] args) {
        var digits = Arrays.asList(0, 1, 2, 3);
        new PlusOne().plusOne(digits);
        System.out.println(digits);
    }
}
