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
    public TreeNode recoverFromPreorder(String str) {
        
        int level = 0, val = 0;
        
        Stack<TreeNode> st = new Stack<>();
        for(int i=0;i<str.length();){
            level = 0;
            while(i<str.length() && str.charAt(i)=='-'){
                level++;
                i++;
            }
            
            val =0;
            while(i<str.length() && str.charAt(i)!='-'){
                val = val*10 + (str.charAt(i)-'0');
                i++;
            }
            
            while(st.size()>level){
                st.pop();
            }
            
            TreeNode root = new TreeNode(val);
            
            if(!st.isEmpty()){
                if(st.peek().left==null){
                    st.peek().left = root;
                }
                else{
                    st.peek().right = root;
                }
            }
            
            st.push(root);
        }
        
        while(st.size()>1)
            st.pop();
        
        return st.peek();
    }
}