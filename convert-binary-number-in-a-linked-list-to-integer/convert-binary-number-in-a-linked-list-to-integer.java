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
    public int getDecimalValue(ListNode head) {
        ListNode prev = null, curr= head, next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            
            prev= curr;
            curr= next;
        }
        
        int count=0, ans=0;
        while(prev!=null){
            ans+=prev.val*((int)Math.pow(2,count));
            prev = prev.next;
            count++;
        }
        
        return ans;
    }
}