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
    public boolean isValidBST(TreeNode root) {

        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }


    private boolean helper(TreeNode cur, int min, int max) {
        if (cur == null) {
            return true;
        }

        if (!(cur.val > min && cur.val < max)) {
            return false;
        }

        return (helper(cur.left, min, cur.val) && helper(cur.right, cur.val, max));

    }
}
