package algorithm_patterns.prefix_sum;

public class LC2381ShiftingLettersII {

    //Resolve by prefix sum and different array pattern
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();

        int[] diffArray = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            int changeValue = (direction == 0) ? -1 : 1;
            diffArray[start] += changeValue;
            diffArray[end + 1] -= changeValue;
        }

        var sb = new StringBuilder();
        var prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += diffArray[i];

            int shift = (prefixSum + (s.charAt(i) - 'a')) % 26;
            if (shift < 0) shift += 26;
            sb.append((char) (shift + 'a'));
        }
        return sb.toString();
    }
}
