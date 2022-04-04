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
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode t=head;
        ListNode reversed=new ListNode(head.val);
        while(t!=null && t.next!=null){
            t=t.next;
            ListNode temp=new ListNode(t.val);
            temp.next=reversed;
            reversed=temp;
        }
        return reversed;
    }
}