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
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
        
    }

    private int helper(TreeNode cur, int maxSoFar) {
        if (cur == null) {
            return 0;
        }

        int res = 0;
        if (cur.val >= maxSoFar) {
            res = 1;
        }

        maxSoFar = Math.max(maxSoFar, cur.val);
        res += helper(cur.left, maxSoFar);
        res += helper(cur.right, maxSoFar);

        return res;
    }
}
