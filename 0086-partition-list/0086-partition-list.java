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
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        List<Integer> less = new ArrayList<>();
        List<Integer> great = new ArrayList<>();
        while(cur != null){
            if(cur.val < x){
                less.add(cur.val);
            }else{
                great.add(cur.val);
            }
            cur = cur.next;
        }
        ListNode temp = new ListNode(0);
        ListNode nn = temp;
        int n1 = less.size();
        int n2 = great.size();
        for(int i=0;i<n1;i++){
            ListNode t = new ListNode(less.get(i));
            nn.next = t;
            nn = nn.next;
        }
        for(int i=0;i<n2;i++){
            ListNode t = new ListNode(great.get(i));
            nn.next = t;
            nn = nn.next;
        }
        return temp.next;
    }
}