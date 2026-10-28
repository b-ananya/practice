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
        ListNode start = list1;
        int count = 0;

        while (count < a - 1) {
            count++;
            start = start.next;
        }

        ListNode end = start.next;
        while (count < b) {
            count++;
            end = end.next;
        }
        
        start.next = list2;

        ListNode cur = list2;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = end;

        return list1;

    }
}
