class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int k = 1;
        Map<Integer, List<Integer>> subarraysMap = getSubarraysMap(nums);
        System.out.println(subarraysMap);

        for (Map.Entry e : subarraysMap.entrySet()) {
            List<Integer> subarray = (List<Integer>) e.getValue();
            k = Math.max(k, subarray.size() / 2);
        }

        List<Integer> keyList = new ArrayList<>(subarraysMap.keySet());
        Collections.sort(keyList);
        for (int i = 0; i < keyList.size() - 1; ++i) {
            int currKey = keyList.get(i);
            int nextKey = keyList.get(i + 1);

            boolean isAdjacent = currKey + subarraysMap.get(currKey).size() == nextKey;
            if (isAdjacent) {
                int minLength = Math.min(subarraysMap.get(currKey).size(), subarraysMap.get(nextKey).size());
                k = Math.max(k, minLength);
            }
        }

        return k;
    }

    private Map<Integer, List<Integer>> getSubarraysMap(List<Integer> nums) {
        Map<Integer, List<Integer>> subarraysMap = new HashMap<>();

        List<Integer> sub = new ArrayList<>();
        subarraysMap.put(0, sub);
        sub.add(nums.get(0));

        for (int i = 1; i < nums.size(); ++i) {
            int prev = nums.get(i - 1);
            int curr = nums.get(i);
            if (prev < curr) {
                sub.add(curr);
            } else {
                sub = new ArrayList<>();
                subarraysMap.put(i, sub);
                sub.add(curr);
            }
        }

        return subarraysMap;
    }
}
