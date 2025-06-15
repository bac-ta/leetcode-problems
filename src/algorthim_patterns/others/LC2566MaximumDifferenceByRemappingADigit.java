package algorthim_patterns.others;

//https://leetcode.com/problems/maximum-difference-by-remapping-a-digit
public class LC2566MaximumDifferenceByRemappingADigit {

    public int minMaxDifference(int num) {
        var numStr = String.valueOf(num);
        var minNumStr = numStr.replaceAll(String.valueOf(numStr.charAt(0)), "0");

        var minNum = Integer.valueOf(minNumStr);

        var indexReplace = 0;
        for (var i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '9')
                continue;
            indexReplace = i;
            break;
        }

        var maxNumStr = numStr.replaceAll(String.valueOf(numStr.charAt(indexReplace)), "9");

        var maxNum = Integer.valueOf(maxNumStr);

        return maxNum - minNum;
    }

}
