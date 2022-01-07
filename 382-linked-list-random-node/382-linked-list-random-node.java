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

    int[] arr;
    public Solution(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while(head!=null){
            head = head.next;
            size++;
        }
        
        arr = new int[size];
        int i=0;
        while(temp!=null){
            arr[i++] = temp.val;
            temp = temp.next;
        }
    }
    
    public int getRandom() {
        return arr[getRandomNumber(0,arr.length)];
    }
    
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */