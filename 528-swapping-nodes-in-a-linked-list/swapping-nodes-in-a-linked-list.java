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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        temp = head;
        int val1 = 0;
        int cnt = 0;
        int val2 = 0;
        while(temp != null){
            cnt++;
            if(cnt == k){
                val1 = temp.val;
            }
            if(cnt == size - k + 1){
                val2 = temp.val;
            }
            temp = temp.next;
        }
        temp = head;
        cnt = 0;
        while(temp != null){
            cnt++;
            if(cnt == k){
                temp.val = val2;
            }
            if(cnt == size - k + 1){
                temp.val= val1;
            }
            temp = temp.next;
        }
        return head;
    }
}