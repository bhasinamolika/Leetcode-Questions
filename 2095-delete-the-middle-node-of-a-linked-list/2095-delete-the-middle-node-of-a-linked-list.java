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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null){
            return null;
        }
        ListNode fast=head.next.next;
        ListNode slow=head;
        // ListNode sentinel=new ListNode();
        // sentinel.next=head;
        // ListNode prev=sentinel;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            //prev=prev.next;
        }
        // now slow pointer is pointing at the node which is to be deleted
        slow.next=slow.next.next;
        return head;
    }
}