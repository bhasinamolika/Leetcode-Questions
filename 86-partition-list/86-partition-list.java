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
        ListNode beforeDummy=new ListNode(0);
        ListNode AfterDummy=new ListNode(0);
        ListNode before=beforeDummy;
        ListNode after=AfterDummy;
        
        while(head!=null){
            if(head.val<x){
                ListNode node=new ListNode(head.val);
                before.next=node;
                before=before.next;
            }
            else{
                ListNode node=new ListNode(head.val);
                after.next=node;
                after=after.next;
            }
            
            head=head.next;
        }
        after.next=null;
        before.next=AfterDummy.next;
        
        return beforeDummy.next;
    }
}