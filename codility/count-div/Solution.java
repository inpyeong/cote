// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int A, int B, int K) {
        // Implement your solution here
        if (A % K != 0) {
            A = A + K;
            if (A > B) {
                return 0;
            }
        }

        int le = A / K;
        int ri = B / K;

        return ri - le + 1;
    }
}
