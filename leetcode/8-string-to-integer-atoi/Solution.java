class Solution {
    public int myAtoi(String s) {
        String tmp = "";
        int sign = 1;

        s = s.trim();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (tmp.isEmpty() && i == 0) {
                if (c == '-') {
                    sign = -1;
                    continue;
                } else if (c == '+') {
                    sign = 1;
                    continue;
                }
            }

            if (tmp.isEmpty() && c == '0') {
                continue;
            }

            if (c < '0' || c > '9') {
                break;
            }

            tmp += c;

            Long check = Long.valueOf(tmp) * sign;
            
            if (check > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
    
            if (check < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        if (tmp.isEmpty()) {
            tmp = "0";
        }

        Long result = Long.valueOf(tmp) * sign;
        return result.intValue();
    }
}
