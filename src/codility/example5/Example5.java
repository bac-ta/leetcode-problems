package codility.example5;

import java.util.Arrays;

public class Example5 {
    public int solution(int[] P, int S[]) {
        int totalPeople = 0;
        for (int p : P) {

            totalPeople += p;
        }

        Arrays.sort(S);
        int currentSeats = 0;
        int carsUsed = 0;
        for (int i = S.length - 1; i >= 0; i--) {
            currentSeats += S[i];
            carsUsed++;
            if (currentSeats >= totalPeople) return carsUsed;
        }

        return carsUsed;
    }
}
