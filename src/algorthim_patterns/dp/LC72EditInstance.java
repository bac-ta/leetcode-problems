package algorthim_patterns.dp;

public class LC72EditInstance {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= length2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // do not nothing
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], // Replace
                            Math.min(
                                    dp[i - 1][j], // Remove
                                    dp[i][j - 1] // Insert
                            )
                    );
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        LC72EditInstance instance = new LC72EditInstance();
        String word1 = "hello duy bac";
        String word2 = "bac duy";
        int minDistance = instance.minDistance(word1, word2);
        System.out.println(minDistance);
    }
}
