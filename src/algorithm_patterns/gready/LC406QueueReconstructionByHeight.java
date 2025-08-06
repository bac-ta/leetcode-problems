package algorithm_patterns.gready;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC406QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        // Sort theo height giảm dần, nếu height bằng thì k tăng dần
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]); // Descending height
            } else {
                return Integer.compare(a[1], b[1]); // Ascending k
            }
        });



        
        // Dùng list để dễ insert vào vị trí k
        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            System.out.println(person[1]);
            System.out.println(Arrays.deepToString(people));
            result.add(person[1], person); // Insert vào đúng vị trí k
        }

        System.out.println(result);



        // Chuyển list về int[][]
        return result.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        new LC406QueueReconstructionByHeight().reconstructQueue(people);
    }
}
