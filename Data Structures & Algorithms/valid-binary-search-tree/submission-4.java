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
    boolean dfs(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }

        if (low >= root.val || high <= root.val) {
            return false;
        }

        return dfs(root.left, low, root.val) && dfs(root.right, root.val, high);
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
