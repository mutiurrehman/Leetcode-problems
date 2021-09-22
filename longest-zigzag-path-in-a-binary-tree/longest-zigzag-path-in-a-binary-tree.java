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
    public int longestZigZag(TreeNode root) {
       if(root == null) 
           return 0;
        helper(root, 0, false);
        
        helper(root, 0, true);
        return max;
    }
    
    int max = 0;
    public void helper(TreeNode root, int depth, boolean dir){
       
        if(root==null)
            return;
         max = Math.max(max, depth);
        if(dir){
             helper(root.left,depth+1,false);
             helper(root.right, 0,false);
        }
        
       else{
            helper(root.right,depth+1,true);
            helper(root.left,0,true);
        }
    }
}