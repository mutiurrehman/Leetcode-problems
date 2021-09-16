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
    public int sumNumbers(TreeNode A) {
        return helper(A,0,0);
    }
    
    public int helper(TreeNode root, int curr, int temp){
       
        temp = temp*10+root.val;
        if(root.left == null && root.right == null){
            curr+=temp;
            return curr;
        }
        
        if(root.left!=null){
            curr= helper(root.left,curr,temp);
        }
        
        if(root.right!=null){
            curr =  helper(root.right,curr,temp);
        }
        
        return curr;
    }
}