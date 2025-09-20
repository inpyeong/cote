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

    static int ANSWER;

    public int diameterOfBinaryTree(TreeNode root) {
        ANSWER = 0;
        doDfs(root);
        return ANSWER;
    }

    int doDfs(TreeNode node) {

        // Base condition
        if (node == null) {
            return 0;
        }

        int leftDepth = doDfs(node.left);
        int rightDepth = doDfs(node.right);

        ANSWER = Math.max(ANSWER, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
