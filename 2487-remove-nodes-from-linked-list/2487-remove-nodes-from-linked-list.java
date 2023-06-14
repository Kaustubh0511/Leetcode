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
    public ListNode removeNodes(ListNode head) {
        // ListNode curr = head;
        // ListNode forward =  curr.next;
        // ListNode prev = head;
        // while(curr != null){
        //     while(forward!=null){
        //         prev = prev.next;
        //         if(forward.val >curr.val){
        //         //    remove(curr,curr.val);
        //             // ListNode prev = head;
        //             if(curr == head){
        //                 head = head.next;
        //                 // return head;
        //             }
        //             else{
        //             prev.next = prev.next.next;
        //             }
        //         }
        //         else{
        //             forward = forward.next;
        //         }
        //     }
        //     curr = curr.next;
        // }
        // return head;
        Stack<Integer> s = new Stack<>();
        ListNode reverse = rev(head);
        while(reverse!=null){

            if(s.isEmpty() || (!s.isEmpty() && reverse.val>=s.peek())){
                s.push(reverse.val);
            }
            

            reverse=reverse.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!s.isEmpty()){
            ListNode temp1 = new ListNode(s.pop());
            curr.next = temp1;
            curr = curr.next;

        }
        return dummy.next;

        
    }
    public ListNode rev(ListNode head){
        ListNode forward=null;
        ListNode perv=null;
        ListNode curr=head;
        while(curr!=null){
            forward=curr.next;
            curr.next=perv;
            perv=curr;
            curr=forward;
        }
        return perv;
    }
}