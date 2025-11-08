class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> indices = new ArrayList<>();
            if (map.containsKey(nums[i])) {
                indices = map.get(nums[i]);
                indices.add(i);
            } else {
                indices.add(i);
            }
            map.put(nums[i], indices);
        }

        System.out.println(map);

        int[] answer = {-1, -1};
        for (int i = 0; i < nums.length; ++i) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                answer[0] = i;
                List<Integer> indices = map.get(diff);
                for (int j = 0; j < indices.size(); ++j) {
                    int idx = indices.get(j);
                    if (idx == i) {
                        continue;
                    } else {
                        answer[1] = idx;
                    }
                }
                if (answer[0] != -1 && answer[1] != -1) {
                    break;
                }
            }
        }
        return answer;
    }
}
