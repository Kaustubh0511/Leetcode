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
    public int size(ListNode head){
        int len = 0;
        ListNode cur = head;
        while(cur!= null){
            len++;
            cur = cur.next;
        }
        return len;
    }
    public int pairSum(ListNode head) {
        int sum =0;
        int max = 0;
        int n = size(head);
        int[] a = new int[n];
        int j =0;
        while(head != null){
            a[j] = head.val;
            head = head.next;
            j++;
        }
        for(int i=0;i<(n/2);i++){
            sum = a[i] + a[n-1-i];
            max = Math.max(max,sum);
        }
        return max;
    }
}