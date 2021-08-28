/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Node implements Comparable<Node>{
    ListNode node;
    int value;
    Node(ListNode node, int value){
        this.node = node;
        this.value = value;
    }
    
    public int compareTo(Node o){
        return this.value - o.value; 
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        ListNode ans = new ListNode(0);
        ListNode ansItr = ans;
        
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
            pq.add(new Node(lists[i],lists[i].val));
        }
        
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            
            ansItr.next = curr.node;
            ansItr = ansItr.next;
            
            if(curr.node.next != null){
                pq.add(new Node(curr.node.next,curr.node.next.val));
            }
        }
        
        return ans.next;
    }
}