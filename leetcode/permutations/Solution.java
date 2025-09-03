class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[10];
        List<Integer> permutations = new ArrayList<>();

        doSolve(nums, permutations, used);
        return answer;
    }

    void doSolve(int[] nums, List<Integer> permutations, boolean[] used) {

        if (permutations.size() == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer perm : permutations) {
                tmp.add(perm);
            }

            answer.add(tmp);
            return;
        }

        for (int i = 0; i < nums.length; ++i) {

            if (used[i] == true) {
                continue;
            }

            permutations.add(nums[i]);
            used[i] = true;

            doSolve(nums, permutations, used);

            permutations.remove(permutations.size() - 1);
            used[i] = false;
        }
    }
}
