/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node==null)
            return node;
        HashSet<Node> visited = new HashSet<>();
        map = new HashMap<>();
        
        return cloneHelper(node,visited);
    }
    
    public Node cloneHelper(Node node, HashSet<Node> visited){
        if(visited.contains(node))
            return map.get(node);
        
        visited.add(node);
        Node clone = new Node(node.val);
        map.put(node,clone);
        for(Node nbr: node.neighbors){
            Node cloneNbr = cloneHelper(nbr,visited);
            clone.neighbors.add(cloneNbr);
        }
        return clone;
        
    }
}