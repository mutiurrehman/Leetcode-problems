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
    public void flatten(TreeNode root) {
        
        if(root==null)
            return;
        
        while(root.left!=null){
            flatten(root.left);
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            
            TreeNode temp = root.right;
            while(temp.right!=null){
                temp = temp.right;
            }
            
            temp.right = right;
        }
        
        flatten(root.right);
    }
}