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
    public TreeNode sortedArrayToBST(int[] A) {
        
  
        return helper(A,0,A.length-1);
    }
    
    public TreeNode helper(int[] A, int s, int e){
        if(s>e)
        return null;
        
        int mid = (s+e)/2;
        TreeNode root = new TreeNode(A[mid]);
        if(s==e)
        return root;
        
        root.left = helper(A,s,mid-1);
        root.right = helper(A,mid+1,e);
        
        return root;
        
    }
}