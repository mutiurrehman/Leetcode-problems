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
    public void reorderList(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        
        ListNode ptr = head;
        while(ptr!=null){
            st.push(ptr);
            ptr=ptr.next;
        }
        ptr=head;
        int cnt = (st.size()-1)/2;
        while(cnt-->0){
            ListNode tmp = ptr.next;
            ListNode top = st.pop();
            ptr.next = top;
            top.next = tmp;
            ptr=tmp;
        }
        st.pop().next=null;

        
    }
}