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
    int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        helper(root);
        return maxValue;
    }
     
     public int helper(TreeNode root){
         if(root==null)
             return 0;
         
         int l = Math.max(0, helper(root.left));
         int r = Math.max(0,helper(root.right));
         
         int temp = l+r+root.val;
         maxValue = Math.max(maxValue, temp);
         
         return Math.max(l,r)+root.val;
     }
}
