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
        
        ListNode temp = head;
        while(temp!=null){
            st.push(temp);
            temp=temp.next;
        }
        temp=head;
        int count = (st.size()-1)/2;
        while(count-->0){
            ListNode cur = st.pop();
            ListNode te = temp.next;
            temp.next =cur;
            cur.next = te;
            temp=te;
        }

        st.pop().next=null;
        
    }
}
