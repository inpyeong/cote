class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> answer = new ArrayList<>();
        for (String w : words) {
            answer.add(w);
        }

        while (true) {
            int index = checkAnagram(answer);
            if (index == -1) {
                break;
            } else {
                answer.remove(index);
            }
        }
        return answer;
    }

    private int checkAnagram(List<String> arr) {
        for (int i = 1; i < arr.size(); ++i) {
            char[] prev = arr.get(i - 1).toCharArray();
            char[] curr = arr.get(i).toCharArray();

            Arrays.sort(prev);
            Arrays.sort(curr);

            if (prev.length == curr.length) {
                boolean flag = false;
                for (int j = 0; j < prev.length; ++j) {
                    if (prev[j] != curr[j]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                } else {
                    return i;
                }
            }

        }
        return -1;
    }
}
