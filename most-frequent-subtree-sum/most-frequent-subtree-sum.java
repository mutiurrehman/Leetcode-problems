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
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        count(root);
        for(int i:list){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        List<Integer> ans = new ArrayList<>();
        int max =1;
        for(int i:map.keySet()){
            max = Math.max(max,map.get(i));
        }
        
        for(int i:map.keySet()){
            if(map.get(i)==max)
                ans.add(i);
        }
        
        int[] res = new int[ans.size()];
        for(int i=0;i<res.length;i++){
            res[i]= ans.get(i);
        }
        
        return res;
    }
    
    List<Integer> list = new ArrayList<>();
    public int count(TreeNode root){
        if(root==null)
            return 0;
        
        int l = count(root.left), r = count(root.right);
        
        list.add(l+r+root.val);
        return l+r+root.val;
    }
}