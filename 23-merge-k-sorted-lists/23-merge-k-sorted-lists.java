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
     ListNode curr;
     int val;
     Node( ListNode curr, int val){
         this.curr=curr;
         this.val=val;
     }
     
     public int compareTo(Node o){
         return this.val - o.val;
    }
     
}

class Solution {
    
    public ListNode mergeKLists(ListNode[] a) {
        
        if(a.length==0)
            return null;
         PriorityQueue<Node> pq = new PriorityQueue<>();
	    ListNode ans = new ListNode(-1);
	    ListNode ansItr = ans;
	    
	    for(int i=0;i<a.length;i++){
            if(a[i]!=null)
	        pq.add(new Node(a[i], a[i].val));
	    }
	    
	    while(!pq.isEmpty()){
	        Node tp = pq.remove();
	        ansItr.next = tp.curr;
	        ansItr = ansItr.next;
	        
	        tp.curr = tp.curr.next;
	        if(tp.curr!=null ){
	            tp.val = tp.curr.val;
	            pq.add(tp);
	        }
	        
	    }
        
	    return ans.next;
	}
}
