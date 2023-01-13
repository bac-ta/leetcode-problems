package single_number;

public class SingleNumber3 {
    public int singleNumber(int A[], int repeating) {
        int count[] = new int[32];
        count[0] = 0;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) == 1) {
                    count[i]++;
                }
            }
            result |= ((count[i] % repeating) << i);
        }
        return result;
    }

    public static void main(String[] args) {
        int A[] = {1, 1, 1, 1, 2, 3, 2, 3, 3, 2, 2, 3, 97, 97, 12, 97, 97};
        var result = new SingleNumber3().singleNumber(A, 4);
        System.out.println(result);
    }
}
