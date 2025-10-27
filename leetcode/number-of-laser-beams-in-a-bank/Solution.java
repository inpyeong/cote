class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int n = bank[0].length();

        if (m == 1) {
            return 0;
        }

        int answer = 0;
        for (int i = 0; i < m - 1; ++i) {

            int j = i + 1;
            while (j < m && countDevices(bank[j]) == 0) {
                j++;
            }

            if (j >= m) {
                return answer;
            } else {
                int numOfDevicesInRow1 = countDevices(bank[i]);
                int numOfDevicesInRow2 = countDevices(bank[j]);

                answer += (numOfDevicesInRow1 * numOfDevicesInRow2);
                i = j - 1;

                // System.out.println(numOfDevicesInRow1 + " " + numOfDevicesInRow2);
            }
        }
        return answer;
    }

    private int countDevices(String row) {
        int result = 0;
        for (char c : row.toCharArray()) {
            if (c == '1') {
                result++;
            }
        }
        return result;
    }
}
