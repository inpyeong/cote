class Solution {

    static String ANSWER;

    public String longestPalindrome(String s) {

        if (s.length() == 1) {
            return s;
        }
        
        String answer = "";
        for (int i = 0; i < s.length(); ++i) {
            int j = 1;
            while ((i - j >= 0) && (i + j < s.length())) {
                String tmp = s.substring(i - j, i + j + 1);
                if (isPalindromic(tmp)) {
                    if (tmp.length() > answer.length()) {
                        answer = tmp;
                    }
                }
                j++;
            }

            int k = 0;
            while ((i - k >= 0) && (i + k + 1 < s.length())) {
                String tmp = s.substring(i - k, i + k + 2);
                if (isPalindromic(tmp)) {
                    if (tmp.length() > answer.length()) {
                        answer = tmp;
                    }
                }
                k++;
            }
        }

        if (answer.length() == 0) {
            return s.substring(0, 1);
        }

        return answer;
    }

    public boolean isPalindromic(String s) {
        int le, ri;
        if (s.length() % 2 == 0) {
            le = s.length() / 2 - 1;
            ri = s.length() / 2;
        } else {
            le = s.length() / 2 - 1;
            ri = s.length() / 2 + 1;
        }

        while (le >= 0 && ri < s.length()) {
            if (s.charAt(le) != s.charAt(ri)) {
                return false;
            }
            le--;
            ri++;
        }
        return true;
    }
}
