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
    public String getDirections(TreeNode root, int p, int q) {
        helper(root,p,q);
        ArrayList<Character> path = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        helper(ans,q,path,false);
        hasPath(ans,arr,p);
        //System.out.println(ans.val);
        StringBuilder res = new StringBuilder();
        for(int i=0;i<arr.size()-1;i++){
            res.append('U');
        }
        
        for(int i=1;i<path.size();i++){
            res.append(path.get(i));
        }
        
        return res.toString();
    }
    
    public void path(TreeNode root, int q){
        if(root==null)
            return;
        
        
    }

    boolean found = false;
    public void helper(TreeNode root, int B,ArrayList<Character> path,boolean dir){
         if(found || root == null)
         return;

        if(!dir)
            path.add('L');
        else
            path.add('R');
         if(root.val==B){
             found = true;
             return;
         }
         if(!found){
           dir = false;
         helper(root.left,B,path,dir);
         }
         if(!found){
             dir = true;
         helper(root.right, B,path,dir);
         }
         if(!found)
         path.remove(path.size()-1);
         
     }
    
    
    public  boolean hasPath(TreeNode root, ArrayList<Integer> arr, int x){

        if (root==null)
            return false;

        arr.add(root.val);    
       
        if (root.val == x)    
            return true;
       
        if (hasPath(root.left, arr, x) ||
            hasPath(root.right, arr, x))
            return true;
        
        arr.remove(arr.size()-1);
        return false;            
    }
    
    TreeNode ans = null;
    public boolean helper(TreeNode root, int p, int q){
        if(root == null)
            return false;
        
        int f = helper(root.left, p, q) ? 1 : 0;
        int s = helper(root.right, p, q) ? 1 : 0;
        int t = (root.val == p || root.val == q) ? 1 : 0;
        
        if((f+s+t)>=2){
            ans = root;   
        }
        
        return (f+s+t)>0;
    }
}