package algorithm_patterns.luhn;

public class LuhnAlgorithm {
    public boolean isValid(String number) {
        if (number == null || number.trim().isEmpty()) {
            return false;
        }
        number = number.replaceAll("\\s+", "");

        if (number.isEmpty()) {
            return false;
        }

        if (!number.matches("\\d+")) {
            return false;
        }

        int sum = 0;
        boolean alternate = false;

        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(number.charAt(i));

            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            alternate = !alternate;
        }

        return (sum % 10 == 0);
    }
}
