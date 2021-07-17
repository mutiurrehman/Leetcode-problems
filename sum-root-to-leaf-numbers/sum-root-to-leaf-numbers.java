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
     long ans=0;
    public int sumNumbers(TreeNode A) {
        
        helper(A);
        return (int)ans;
    }
    
    long temp=0;
    public void helper(TreeNode root){
        if(root== null)
        return;
        temp=(temp*10+root.val);
        if(root.left==null && root.right==null){
            ans+=temp;
        }
        
        helper(root.left);
        helper(root.right);
        
        temp=temp/10;
    }
}