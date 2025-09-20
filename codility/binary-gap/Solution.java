// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // Implement your solution here
        int answer = 0;

        String bin = toBinary(N);
        // System.out.println(bin);

        boolean flag = false;
        int ans = 0;
        for (int i = 0; i < bin.length() - 1; ++i) {
            char c = bin.charAt(i);
            if (c == '0') {
                ans++;
                if (bin.charAt(i + 1) == '1') {
                    answer = Math.max(answer, ans);
                    ans = 0;
                }
            }
        }

        return answer;
    }

    String toBinary(int num) {
        String result = "";
        while (num > 0) {
            int remainder = num % 2;
            result = remainder + result;

            num = num / 2;
        }

        return result;
    }
}
