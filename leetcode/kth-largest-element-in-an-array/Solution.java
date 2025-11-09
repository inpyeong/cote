class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Initialize max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            maxHeap.offer(num);
        }

        int answer = -1;
        int i = 0;
        while (!maxHeap.isEmpty() && i < k) {
            answer = maxHeap.poll();
            i++;
        }
        return answer;
    }
}
