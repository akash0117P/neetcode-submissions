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
    int ans = 0;
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int lh =  maxDepth(root.left);
        int rh =  maxDepth(root.right);

        ans = Math.max((lh + rh), ans);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return ans;
    }
}
