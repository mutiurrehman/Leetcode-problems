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
     List<Integer> vals;
    public boolean findTarget(TreeNode root, int k) {
        vals = new ArrayList();
        dfs(root);
        int i=0,j=vals.size()-1;
        
        while(i<j){
            int sum = vals.get(i)+vals.get(j);
            if(sum==k)
                return true;
            
            if(sum<k)
                i++;
            else
                j--;
        }
        return false;
    }
    
    
     public void dfs(TreeNode node) {
        if (node != null) {
           
            dfs(node.left);
            vals.add(node.val);
            dfs(node.right);
        }}
         
    
}