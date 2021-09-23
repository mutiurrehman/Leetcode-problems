/*
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
    public int maxSumBST(TreeNode root) {
        
        count(root);
        return maxSum;
    }
    
    int maxSum=0;
    public int[] count(TreeNode root){
        if(root == null)
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
     
        int[] l = count(root.left), r= count(root.right);
        if( !(l!=null && r!=null && root.val>l[1] && root.val<r[0]))
            return null;
        int sum = l[2]+r[2]+root.val;
        
        maxSum = Math.max(maxSum, sum);
        int min = Math.min(root.val, l[0]);
        int max = Math.max(root.val, r[1]);
        
        return new int[]{min, max, sum};
    }
    
}