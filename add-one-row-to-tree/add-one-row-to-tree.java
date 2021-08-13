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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level=1;
        boolean check = false;
        while(!q.isEmpty()){
            int size = q.size();
          
            for(int i=0;i<size;i++){
                TreeNode curr = q.remove();
                if(curr.left!=null){
                    TreeNode temp = curr.left;
                    if(level==d-1){
                        curr.left = new TreeNode(v);
                        curr.left.left= temp;
                        check =true;
                    }
                    else{
                        q.add(curr.left);
                    }
                }
                else{
                    if(level==d-1){
                         curr.left = new TreeNode(v);
                        check =true;
                    }
                }
                
                if(curr.right!=null){
                    TreeNode temp = curr.right;
                    if(level==d-1){
                        curr.right = new TreeNode(v);
                        curr.right.right= temp;
                        check = true;
                    }
                    else{
                        q.add(curr.right);
                    }
                }
                else{
                    if(level==d-1){
                         curr.right = new TreeNode(v);
                        check =true;
                    }
                }   
            }
            level++;
            if(check)
                break;
        }
        
        return root;
    }
}