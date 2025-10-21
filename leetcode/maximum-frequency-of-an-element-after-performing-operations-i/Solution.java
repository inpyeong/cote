class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int maxFreq = 0;
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int i : nums) freq.put(i,freq.getOrDefault(i,0)+1);

        for (int i = nums[0]-k; i <= nums[nums.length-1]+k; i++) {
            int target = i;
            int initialCount = freq.getOrDefault(target,0);

            int leftBound = target - k;
            int rightBound = target + k;

            int startIdx = binarySearchLeft(nums, leftBound);
            int endIdx = binarySearchRight(nums, rightBound);

            int potentialGroupSize = endIdx - startIdx;
            int convertibleCount = potentialGroupSize - initialCount;

            int opsToUse = Math.min(numOperations, convertibleCount);

            int currentFreq = initialCount + opsToUse;
            maxFreq = Math.max(maxFreq, currentFreq);

        }

        return maxFreq;
    }

    private int binarySearchLeft(int[] nums, int val) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < val) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int binarySearchRight(int[] nums, int val) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= val) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
