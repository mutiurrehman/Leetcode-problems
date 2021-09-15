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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Stack<Integer> st = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.right!=null)
                    q.add(curr.right);
                if(curr.left!=null)
                    q.add(curr.left);
                
                st.push(curr.val);
            }
            st.push(null);
        }
        st.pop();
    
        System.out.println(st);
        List<Integer> temp =new ArrayList<>();
        while(!st.isEmpty()){
            Integer curr = st.pop();
            if(curr==null){
                ans.add(temp);
                temp =new ArrayList<>();
            }
            else{
               
                temp.add(curr);
            }
        }
        
        if(temp.size()>0)
            ans.add(temp);
       
        return ans;
    }
}