class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        
        int answer = 1;
        int n = s.length();
        int start = 0, end = 0;

        while (start < n && end < n && start <= end) {
            String substr = s.substring(start, end + 1);

            if (!hasDuplicatedChars(substr)) {
                answer = Math.max(answer, substr.length());
                end++;
            } else {
                start++;
            }
        }
        return answer;
    }

    private boolean hasDuplicatedChars(String s) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        for (int count : charCounts.values()) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}
