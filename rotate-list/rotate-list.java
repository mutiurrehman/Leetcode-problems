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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null)
            return head;
        int size=0;
        
        ListNode temp = head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        
        k=k%size;
        if(k==0)
            return head;
        
        k=size-k;
        if(k==0)
            return head;
        
        temp=head;
        ListNode newBack=temp;
        
        while(k!=1){
            temp=temp.next;
            k--;
        }
        ListNode newFront= temp.next, nfi=newFront;
        temp.next=null;
        
        while(nfi.next!=null){
            nfi=nfi.next;
        }
        
        nfi.next=newBack;
        
        return newFront;
    }
}