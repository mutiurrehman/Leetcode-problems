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
    public ListNode[] splitListToParts(ListNode head, int k) {
      
        ListNode[] res = new ListNode[k];
          if(head==null)
            return res;
        int size=0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
            int rem = size%k;
            temp = head;
            int que = size/k;
            int index=0;
            while(temp!=null){
                int curr = que;
                if(rem>0){
                    curr+=1;
                    rem--;
                }
                
                ListNode d = temp;
                while(curr-->1){
                    d = d.next;
                }
                ListNode c = d!=null? d.next: null;
                if(d!=null)
                    d.next = null;
                res[index] = temp;
                index++;
                temp = c;
            }
        
        return res;
    }
}