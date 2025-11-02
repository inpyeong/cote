/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<Integer, List<Integer>> nodeMap;

    public List<Integer> rightSideView(TreeNode root) {
        // Put nodes by each tree level.
        nodeMap = new HashMap<>();
        putNodes(root, 0);

        List<Integer> answer = new ArrayList<>();
        for (Map.Entry e : nodeMap.entrySet()) {
            List<Integer> vals = (List) e.getValue();
            answer.add(vals.get(vals.size() - 1));
        }
        return answer;
    }

    private void putNodes(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (nodeMap.containsKey(level)) {
            List<Integer> nodeVals = nodeMap.get(level);
            nodeVals.add(root.val);
            nodeMap.put(level, nodeVals);
        } else {
            List<Integer> nodeVals = new ArrayList<>();
            nodeVals.add(root.val);
            nodeMap.put(level, nodeVals);
        }

        putNodes(root.left, level + 1);
        putNodes(root.right, level + 1);
    }
}
