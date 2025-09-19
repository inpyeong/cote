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

    public boolean isSameTree(TreeNode p, TreeNode q) {

        List<Integer> pVisitedOrder = new ArrayList<>();
        List<Integer> qVisitedOrder = new ArrayList<>();

        doDfs(p, pVisitedOrder);
        doDfs(q, qVisitedOrder);

        if (pVisitedOrder.size() != qVisitedOrder.size()) {
            return false;
        }

        for (int i = 0; i < pVisitedOrder.size(); ++i) {

            Integer pVal = pVisitedOrder.get(i);
            Integer qVal = qVisitedOrder.get(i);

            if (pVal == null && qVal == null) {
                continue;
            }

            if (pVal != null && qVal != null) {
                if (pVal.toString().equals(qVal.toString())) {
                    continue;
                }
            }
            
            return false;
        }

        return true;
    }

    void doDfs(TreeNode node, List<Integer> visitedOrder) {
        if (node == null) {
            visitedOrder.add(null);
            return;
        }

        visitedOrder.add(node.val);

        if (node.left == null && node.right == null) {
            // Leaf node
            return;
        }

        doDfs(node.left, visitedOrder);
        doDfs(node.right, visitedOrder);
    }
}
