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
    ListNode sort;
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        while(cur!= null){
            ListNode next = cur.next;
            sortedInsert(cur);
            cur = next;
        }
        head = sort;
        return head;
    }
    public ListNode sortedInsert(ListNode cur){
        if(sort == null || sort.val >= cur.val){
            cur.next = sort;
            sort = cur;
        }
        else{
            ListNode temp = sort;
            while(temp.next != null && temp.next.val < cur.val){
                temp = temp.next;
            }
            cur.next = temp.next;
            temp.next = cur;
        }
        return sort;
    }
}