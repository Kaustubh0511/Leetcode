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
    public ListNode Reverse(ListNode head){
         ListNode prev = null, temp;
        while (head != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;    
        }    
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0,totalSum = 0; 
        ListNode r1 = Reverse(l1);
        ListNode r2 = Reverse(l2);
        while (r1 != null || r2 != null) {
            if (r1 != null) totalSum += r1.val;
            if (r2 != null) totalSum += r2.val;
            
            dummy.val = totalSum % 10;
            carry = totalSum / 10;
            ListNode head = new ListNode(carry);
            head.next = dummy;
            dummy = head;
            totalSum = carry;

            r1 = r1 != null ? r1.next : null;
            r2 = r2 != null ? r2.next : null;
        }
        return carry == 0 ? dummy.next : dummy;
    }
}