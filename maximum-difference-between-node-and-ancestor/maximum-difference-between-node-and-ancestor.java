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
    public int maxAncestorDiff(TreeNode root) {
        
        helper(root);
        return max;
    }
    
    int max = Integer.MIN_VALUE;
    
    public void max(TreeNode root, int val){
        if(root==null)
            return;
        
        max = Math.max(Math.abs(root.val-val),max);
        max(root.left,val);
        max(root.right,val);
    }
    
    
    public void helper(TreeNode root){
        if(root == null)
            return;
        
        max(root,root.val);
        max(root.left, root.val);
        max(root.right, root.val);
        
        helper(root.left);
        helper(root.right);
    }
}