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
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;
    public void recoverTree(TreeNode root) {
         if(root==null) return;
        first = null;
        second = null;
        prev = null;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        if(first == null && (prev==null || prev.val>=root.val)){
            first = prev;
        }
         if(first!=null && prev.val>=root.val)
            second = root;
        
        prev = root;
        inorder(root.right);
    }
}