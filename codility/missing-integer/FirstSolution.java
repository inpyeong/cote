// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);

        if (A[A.length - 1] <= 0) {
            return 1;
        }
        if (A[0] > 1) {
            return 1;
        }

        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i + 1] <= 0) {
                continue;
            }
            if (A[i + 1] - A[i] > 1) {
                return A[i] + 1 > 0 ? A[i] + 1 : 1;
            }
        }

        return A[A.length - 1] + 1;
    }
}
