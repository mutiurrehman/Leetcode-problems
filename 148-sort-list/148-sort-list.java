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
class Solution {
    public ListNode sortList(ListNode head) {
     
        if(head==null || head.next == null)
            return head;
        
        ListNode mid = getMiddle(head);
        ListNode sec = mid.next;
        mid.next = null;
        
        ListNode first = sortList(head);
        ListNode second = sortList(sec);
        
        ListNode merged= merge(first,second);
        
        return merged;
        
    }
    
    public ListNode getMiddle(ListNode head){
        if(head == null)
            return head;
        
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;          
        }
        
        return slow;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        if(l1==null)
            return l2;
        
        if(l2==null)
            return l1;
        
        ListNode temp = null;
        if(l1.val<=l2.val){
            temp = l1;
            temp.next = merge(l1.next,l2);
        }
        else{
            temp = l2;
            temp.next = merge(l1, l2.next);
        }
        
        return temp;
    }
}