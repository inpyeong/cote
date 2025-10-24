class Solution {
    public int nextBeautifulNumber(int n) {
        List<Integer> balanced = buildBalanced();
        return balanced.get(lowerBound(balanced, n));
    }

    private List<Integer> buildBalanced() {
        int[][][] combinations = {
            {{1}},
            {{2}},
            {{1, 2}, {3}},
            {{1, 3}, {4}},
            {{1, 4}, {2, 3}, {5}},
            {{1, 5}, {1, 2, 3}, {2, 4}, {6}},
        };

        Set<String> balancedSet = new HashSet<>();
        for (int[][] comb : combinations) {
            for (int i = 0; i < comb.length; ++i) {
                List<Integer> digits = new ArrayList<>();
                for (int j = 0; j < comb[i].length; ++j) {
                    for (int k = 0; k < comb[i][j]; ++k) {
                        digits.add(comb[i][j]);
                    }
                }
                boolean[] used = new boolean[digits.size()];
                findBalanced(balancedSet, digits, used, "");
            }
        }

        List<Integer> balanced = new ArrayList<>();
        for (String s : balancedSet) {
            balanced.add(convertToInteger(s));
        }
        Collections.sort(balanced);
        balanced.add(1224444); // Only for 7
        
        return balanced;
    }

    private void findBalanced(
        Set<String> balanced, 
        List<Integer> digits, 
        boolean[] used,
        String balStr
    ) {
        if (balStr.length() == digits.size()) {
            balanced.add(balStr);
            return;
        }
        
        for (int i = 0; i < digits.size(); ++i) {
            if (used[i]) {
                continue;
            }

            Integer curr = digits.get(i);
            used[i] = true;

            findBalanced(balanced, digits, used, balStr + curr.toString());
            used[i] = false;
        }
    }

    private int convertToInteger(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            result += (c - '0');
            if (i < s.length() - 1) {
                result *= 10;
            }
        }
        return result;
    }

    private int lowerBound(List<Integer> balanced, int target) {
        int low = 0, high = balanced.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (balanced.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
