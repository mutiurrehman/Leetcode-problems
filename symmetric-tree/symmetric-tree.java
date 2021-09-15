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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left,root.right);
    }
    
    public boolean helper(TreeNode f, TreeNode s){
        if(f==null && s==null)
            return true;
        
        if(f==null || s==null)
            return false;
        
        return helper(f.left,s.right) && helper(f.right,s.left) && f.val==s.val;
    }
}