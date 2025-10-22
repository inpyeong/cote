class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);

        Set<Integer> modesSet = new HashSet<>();
        for (int num : nums) {
            modesSet.add(num);
            modesSet.add(num - k);
        }

        List<Integer> modes = new ArrayList<>(modesSet);
        Collections.sort(modes);

        int maxFreq = 0;

        for (int target : modes) {
            int initialCount = binarySearchRight(nums, target) - binarySearchLeft(nums, target);
            int potentialGroupSize = binarySearchRight(nums, target + k) - binarySearchLeft(nums, target - k);

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
