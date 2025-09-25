// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int toWest = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = A.length - 1; i >= 0; --i) {
            if (A[i] == 1) {
                toWest++;
            } else {
                answer += toWest;
            }
        }
        return answer;
    }
}
