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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int xLevel = 0, yLevel = 0;
        int level = 0;
        TreeNode parentX=null,parentY=null;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null){
                    if(curr.left.val==x){
                        xLevel = level+1;
                        parentX = curr;
                    }   
                    if(curr.left.val==y){
                        yLevel = level+1;
                        parentY = curr;
                    }
                    q.add(curr.left);
                }
                
                if(curr.right!=null){
                    if(curr.right.val==x){
                        xLevel = level+1;
                        parentX = curr;
                    }   
                    if(curr.right.val==y){
                        yLevel = level+1;
                        parentY = curr;
                    }
                    q.add(curr.right);
                }
            }
        }
        
        if(parentX==parentY)
            return false;
        
        return xLevel==yLevel;
    }
}