/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph(root);
        HashSet<TreeNode> visited = new HashSet<>();
        dfs(map,0,k,visited,target);
        return ans;
    }
    
    List<Integer> ans = new ArrayList<>();
    
    public void dfs(HashMap<TreeNode, ArrayList<TreeNode>> map, int curDist, int k , HashSet<TreeNode> visited, TreeNode u){
        if(k==curDist){
            ans.add(u.val);
           // return;
        }
        
        visited.add(u);
        if(map.get(u)!=null){
        for(int i=0;i<map.get(u).size();i++){
            TreeNode v = map.get(u).get(i);
            if(!visited.contains(v)){
                dfs(map,curDist+1,k,visited,v);
            }
        }
        }
        //curDist=0;
    }
    

    HashMap<TreeNode, ArrayList<TreeNode>> map = new HashMap<>();
    public void graph(TreeNode root){
        if(root==null)
            return;
        
        if(root.left!=null){
            if(map.containsKey(root)){
                map.get(root).add(root.left);
                if(map.containsKey(root.left))
                    map.get(root.left).add(root);
                else{
                    map.put(root.left,new ArrayList<TreeNode>());
                    map.get(root.left).add(root);
                }
            } else{
                map.put(root,new ArrayList<TreeNode>());
                map.get(root).add(root.left);
                if(map.containsKey(root.left))
                    map.get(root.left).add(root);
                else{
                    map.put(root.left,new ArrayList<TreeNode>());
                    map.get(root.left).add(root);
                }
            }
        }
        
         if(root.right!=null){
            if(map.containsKey(root)){
                map.get(root).add(root.right);
                if(map.containsKey(root.right))
                    map.get(root.right).add(root);
                else{
                    map.put(root.right,new ArrayList<TreeNode>());
                    map.get(root.right).add(root);
                }
            } else{
                map.put(root,new ArrayList<TreeNode>());
                map.get(root).add(root.right);
                if(map.containsKey(root.right))
                    map.get(root.right).add(root);
                else{
                    map.put(root.right,new ArrayList<TreeNode>());
                    map.get(root.right).add(root);
                }
            }
        }
        
        graph(root.left);
        graph(root.right);
    }
}