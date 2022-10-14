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
if(head==null || head.next==null){
return null;
}
ListNode cc=head;
int count=0;
while(cc!=null){
count++;
cc=cc.next;

    }
    ListNode cur=head;
    ListNode frwd=head.next;
    for(int i=0;i<count/2-1;i++){
        if(frwd!=null){
            frwd=frwd.next;
            cur=cur.next;
        }
    }
    cur.next=frwd.next;
    return head;
}
}