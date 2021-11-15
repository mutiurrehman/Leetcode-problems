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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode temp = head;
        
        int grp = 1;
        while(temp!=null){
            int count=0;
            ListNode start = temp;
            Stack<Integer> st = new Stack<>();
            
            while(count!=grp && temp!=null){
                st.push(temp.val);
                temp = temp.next;
                count++;
            }
            
            if(count%2==0){
                while(start!=temp){
                    start.val = st.pop();
                    start = start.next;
                }
            }
            grp++;
        }
        
        return head;
    }
}