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
    int pind; 
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        pind = postorder.length-1;
        for(int i= 0;i<inorder.length;i++)
            map.put(inorder[i],i);
        
        return helper(postorder,0,postorder.length-1);
    }
    
    public TreeNode helper(int[] postorder, int l, int r){
        if(l>r)
            return null;
        
        int index = map.get(postorder[pind]);
        
        TreeNode root = new TreeNode(postorder[pind--]);
        
        root.right = helper(postorder,index+1,r);
        root.left = helper(postorder,l,index-1);
        
        return root;
    }
}