class Solution {
    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            String result = "";
            for (int i = 0; i < s.length() - 1; ++i) {
                int le = s.charAt(i) - '0';
                int ri = s.charAt(i + 1) - '0';
                result = result + (le + ri) % 10;
            }
            s = result;
        }
        return s.charAt(0) == s.charAt(1);
    }
}
