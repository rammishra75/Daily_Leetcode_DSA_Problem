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
    public int[] nextLargerNodes(ListNode head) {
        ListNode curr = head;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }
        int len = list.size();
        int[] ans = new int[len];
        for(int i = len - 1; i >= 0; i--){
            int ele = list.get(i);
            while(!stk.isEmpty() && stk.peek() <= ele){
                stk.pop();
            }
            if(stk.isEmpty()) ans[i] = 0;
            else ans[i] = stk.peek();
            stk.push(ele);
        }
        return ans;
    }
}