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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        int count1=0;
        ListNode temp = list1;
        while(temp!=null &&count1<a-1){
            temp=temp.next;
            count1++;
        }
        
        int count2=0;
        ListNode temp2 = list1;
        while(temp2!=null && count2<b){
            temp2=temp2.next;
            count2++;
        }
        
        ListNode toAttach = temp2.next;
        temp.next = list2;
        
        while(list2.next!=null){
            list2=list2.next;
        }
        
        list2.next = toAttach;
        
        return list1;
    }
}