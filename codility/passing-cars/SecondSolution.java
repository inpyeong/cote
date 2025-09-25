/ you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        long toWest = 0;
        long answer = 0;
        
        for (int i = A.length - 1; i >= 0; --i) {
            if (A[i] == 1) {
                toWest++;
            } else {
                answer += toWest;
                // 1,000,000,000 초과 체크
                if (answer > 1000000000) {
                    return -1;
                }
            }
        }
        
        return (int) answer;
    }
}
