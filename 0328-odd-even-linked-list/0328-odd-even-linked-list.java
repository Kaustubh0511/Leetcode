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
    public ListNode oddEvenList(ListNode head) {
        ListNode eh=null,et=null,oh=null,ot = null;
        int count=0;
        ListNode curr = head;
        while(curr!=null){
                count++;
                if(count%2 != 0){  if(oh==null) {oh = ot = curr;}  
                else  {ot.next = curr;  ot = ot.next; } 
        }
        else{
            if(eh==null){
            eh = et = curr;
            }
            else{
                et.next = curr;
                et = et.next;
            }
        }
        curr = curr.next;
        }
        if(oh==null || eh==null)   
            return head;
        ot.next = eh;
        et.next = null;    
        return oh;
    }
}