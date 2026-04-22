package codility.lesson1.iterations.binarygap;

public class BinaryGap {
    public int solution(int N) {
        // First: we convert the integer N to String
        String binary = Integer.toBinaryString(N);
        // Defined variable maxGap, currentGap, and inGap
        int maxGap = 0;
        int currentGap = 0;
        boolean inGap = false;

        for (char c : binary.toCharArray()) {
            if (c == '1') {
                if (inGap) maxGap = Math.max(maxGap, currentGap);
                // Reset current gap and mark that we've started
                currentGap = 0;
                inGap = true;
            } else if (inGap) {
                currentGap++;
            }
        }
        return maxGap;
    }

    // Test the solution
    public static void main(String[] args) {
        BinaryGap bg = new BinaryGap();

        System.out.println(bg.solution(9));     // 2  (1001)
        System.out.println(bg.solution(529));   // 4  (1000010001)
        System.out.println(bg.solution(20));    // 1  (10100)
        System.out.println(bg.solution(15));    // 0  (1111)
        System.out.println(bg.solution(1041));  // 5  (10000010001)
        System.out.println(bg.solution(1));     // 0
        System.out.println(bg.solution(2147483647)); // 0 (all 1s)
    }
}
