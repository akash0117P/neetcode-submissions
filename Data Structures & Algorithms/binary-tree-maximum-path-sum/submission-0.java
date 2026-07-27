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
    int maxi = Integer.MIN_VALUE;
    int find(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = Math.max(0, find(root.left));
        int rightSum = Math.max(0, find(root.right));

        maxi = Math.max((root.val + leftSum + rightSum), maxi);
        return root.val + Math.max(leftSum, rightSum);
    }
    public int maxPathSum(TreeNode root) {
        find(root);
        return maxi;
    }
}
