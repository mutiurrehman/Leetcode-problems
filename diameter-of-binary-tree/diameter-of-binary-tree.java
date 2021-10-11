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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max-1;
        
    }
    
    public int helper(TreeNode root){
        if(root==null)
            return 0;
        
        int l = helper(root.left);
        int r = helper(root.right);
        
        int temp = l+r+1;
       
        max = Math.max(max, temp);
        
        return Math.max(l,r)+1;
    }
}