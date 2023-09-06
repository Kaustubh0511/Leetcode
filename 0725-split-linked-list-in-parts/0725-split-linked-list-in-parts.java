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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur =  head;
        int N =  0;
        while(cur != null){
            cur = cur.next;
            N++;
        }
        int width = N/k, rem = N%k;
        ListNode[] res = new ListNode[k];
        
        cur = head;
        for(int i = 0;i<k;i++){
            ListNode root = new ListNode(0);
            ListNode temp = root;
            for(int j=0;j<width + (i < rem ? 1 : 0);j++){
                temp = temp.next = new ListNode(cur.val);
                if(cur != null) cur = cur.next;
            }
            res[i] = root.next;
        }
        return res;
    }
}