package algorthim_patterns.others;

//https://leetcode.com/problems/maximum-difference-by-remapping-a-digit
public class LC2566MaximumDifferenceByRemappingADigit {

    public int minMaxDifference(int num) {
        var numStr = String.valueOf(num);

        var firstEl = numStr.charAt(0);
        var minNumStr = numStr.replaceAll(String.valueOf(firstEl), "0");

        var minNum = Integer.valueOf(minNumStr);

        String maxNumStr = "";

        if (firstEl == '9' && numStr.length() > 1) {
            maxNumStr = numStr.replaceAll(String.valueOf(numStr.charAt(1)), "9");
        } else {
            maxNumStr = numStr.replaceAll(String.valueOf(firstEl), "9");
        }

        var maxNum = Integer.valueOf(maxNumStr);

        return maxNum - minNum;
    }

}
