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
    void find(TreeNode root, int max) {
        if (root == null)
            return;

        if (root.val >= max) {
            ans++;
            max = root.val;
        }

        find(root.left, max);
        find(root.right, max);
        return;
    }
    public int goodNodes(TreeNode root) {
        find(root, Integer.MIN_VALUE);
        return ans;
    }
}
