// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int K) {
        // Implement your solution here
        if (A.length == 0) {
            return new int[]{};
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < A.length; ++i) {
            list.add(A[i]);
        }

        for (int i = 0; i < K; ++i) {
            int last = list.get(list.size() - 1);
            list.removeLast();
            list.add(0, last);
        }

        int[] answer = new int[A.length];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
