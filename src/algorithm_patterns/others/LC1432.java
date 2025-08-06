package algorithm_patterns.others;

public class LC1432 {
    public int maxDiff(int num) {
        // Make a number as is maximum
        var numStr = String.valueOf(num);
        var indexReplace = 0;
        for (var i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '9')
                continue;
            indexReplace = i;
            break;
        }

        var maxNumStr = numStr.replaceAll(String.valueOf(numStr.charAt(indexReplace)), "9");
        var maxNum = Integer.valueOf(maxNumStr);

        // Make b number as minimum

        var indexReplace2 = 0;

        for (var i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '1' || numStr.charAt(i) == '0')
                continue;

            indexReplace2 = i;
            break;
        }

        String minNumStr;
        if (indexReplace2 == 0) {
            minNumStr = numStr.replaceAll(String.valueOf(numStr.charAt(indexReplace2)), "1");
        } else {
            minNumStr = numStr.replaceAll(String.valueOf(numStr.charAt(indexReplace2)), "0");
        }

        var minNum = Integer.valueOf(minNumStr);

        return maxNum - minNum;
    }

    public static void main(String[] args) {
        new LC1432().maxDiff(1101057);
    }
}
