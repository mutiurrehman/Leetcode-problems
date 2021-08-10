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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int pos = 1;
        ListNode curr=head,start=curr;
        while(pos<left){
            start=curr;
            curr=curr.next;
            pos++;
        }
        
        ListNode prev=null,curr2=curr,next;
        while(pos<=right){
            next=curr.next;
            curr.next=prev;
            
            prev=curr;
            curr=next;
            pos++;
        }
        
        start.next=prev;
        curr2.next=curr;
        if(left==1)
            return prev;
        
        return head;
    }
}