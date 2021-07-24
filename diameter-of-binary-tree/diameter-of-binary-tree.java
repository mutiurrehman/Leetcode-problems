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
    public int diameterOfBinaryTree(TreeNode root) {
         helper(root);
        
        return res-1;
    }
    
    int res=Integer.MIN_VALUE;
    public int helper(TreeNode root){
        if(root==null)
            return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int temp = Math.max(left,right)+1;
       
        res=Math.max(res,1+left+right);
        
        return temp;
        
    }
}