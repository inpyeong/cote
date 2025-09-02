class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int index = 0, sum = 0;
        List<Integer> comb = new ArrayList<>();

        doSolve(candidates, target, index, sum, comb);

        return answer;
    }

    void doSolve(
        int[] candidates, int target, int index, int sum, List<Integer> comb
    ) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            List<Integer> ans = new ArrayList<>();
            for (Integer c : comb) {
                ans.add(c);
            }

            answer.add(ans);
            return;
        }

        for (int i = index; i < candidates.length; ++i) {
            comb.add(candidates[i]);
            doSolve(candidates, target, i, sum + candidates[i], comb);
            comb.remove(comb.size() - 1);
        }
    }
}
