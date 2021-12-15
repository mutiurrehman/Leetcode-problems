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
    public ListNode insertionSortList(ListNode head) {
        
        ListNode temp = head;
        while(temp!=null){
            ListNode curr = head;
            while(curr!=null){
                if(temp.val<curr.val){
                    int cc = curr.val;
                    curr.val = temp.val;
                    temp.val = cc;
                }
                else{
                    curr = curr.next;
                }
            }
            temp = temp.next;
        }
        
        return head;
    }
}