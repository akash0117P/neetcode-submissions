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
    int temp = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;
        kthSmallest(root.left,k);

        ans++;

        if (ans == k)
        temp = root.val;

        kthSmallest(root.right,k);

        return temp;
    }
}
