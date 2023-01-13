package reverse_integer;

public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            // handle overflow/underflow
            if (Math.abs(result) > 214748364) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        var result = new ReverseInteger().reverse(1222);
        System.out.println(result);
    }
}
