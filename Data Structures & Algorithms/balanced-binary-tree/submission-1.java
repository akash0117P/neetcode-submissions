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
    boolean ans = true;
    int find(TreeNode root) {
        if (root == null)
            return 0;

        int lh = find(root.left);
        int rh = find(root.right);

        if ((lh > rh) && (lh - rh) > 1) {
            ans = false;
        }

        if ((lh < rh) && (rh - lh) > 1) {
            ans = false;
        }

        return 1 + Math.max(lh, rh);
    }
    public boolean isBalanced(TreeNode root) {
        find(root);
        return ans;
    }
}
