package algorthim_patterns.binary_search;

public class LC35SearchInsertPosition {

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
