package codility.example1;

public class LargestCommonLetterFinder {
    public String solution(int AA, int AB, int BB) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            boolean placed = false;
            boolean endAA = AA > 0 && sb.charAt(sb.length() - 1) == 'A' && sb.charAt(sb.length() - 2) == 'A';
            boolean endBB = BB > 0 && sb.charAt(sb.length() - 1) == 'B' && sb.charAt(sb.length() - 2) == 'B';

            if (AA > 0 && !endAA && AA >= BB) {
                sb.append("AA");
                AA--;
                placed = true;
            } else if (BB > 0 && !endBB) {
                sb.append("BB");
                BB--;
                placed = true;
            } else if (AB > 0 && !endAA) {
                sb.append("AB");
                AB--;
                placed = true;
            }
            if (!placed) break;
        }
        return sb.toString();
    }
}
