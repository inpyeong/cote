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
    public boolean isSymmetric(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        doDfs(root.left, left, Side.LEFT);
        doDfs(root.right, right, Side.RIGHT);

        if (left.size() != right.size()) {
            return false;
        }

        for (int i = 0; i < left.size(); ++i) {
            if (left.get(i) != right.get(i)) {
                return false;
            }
        }
        return true;
    }

    void doDfs(TreeNode node, List<Integer> visited, Side side) {
        if (node == null) {
            visited.add(null);
            return;
        }

        visited.add(node.val);
        if (node.left == null && node.right == null) {
            // Leaf node
            return;
        }

        if (side == Side.LEFT) {
            doDfs(node.left, visited, side);
            doDfs(node.right, visited, side);
        } else {
            doDfs(node.right, visited, side);
            doDfs(node.left, visited, side);
        }
    }

    enum Side {
        LEFT, RIGHT;
    }
}
