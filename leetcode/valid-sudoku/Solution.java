class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {

                int y = i;
                int x = j;

                // Rule #1
                if (x == 0) {
                    if (!validateRules(board[y])) {
                        return false;
                    }
                }

                // Rules #2
                if (y == 0) {
                    char[] tmp = new char[9];
                    for (int k = 0; k < 9; ++k) {
                        tmp[k] = board[k][x];
                    }
                    if (!validateRules(tmp)) {
                        return false;
                    }
                }

                // Rules #3
                if (y % 3 == 0 && x % 3 == 0) {
                    char[] tmp = new char[9];
                    for (int k = 0; k < 3; ++k) {
                        for (int l = 0; l < 3; ++l) {
                            int ny = y + k;
                            int nx = x + l;

                            tmp[k * 3 + l] = board[ny][nx];
                        }
                    }
                    if (!validateRules(tmp)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean validateRules(char[] numbers) {
        // System.out.println(numbers);
        Map<Character, Integer> countByValue = new HashMap<>();

        for (int i = 0; i < numbers.length; ++i) {
            char value = numbers[i];

            if (value == '.') {
                continue;
            }

            if (countByValue.containsKey(value)) {
                int count = countByValue.get(value);
                countByValue.put(value, count + 1);
            } else {
                countByValue.put(value, 1);
            }
        }

        for (int count : countByValue.values()) {
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
