/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
	//if the node is null, just return
        if(node == null) return;
		// we use the pre to keep track of the pre node, next is the next node
        ListNode next = node.next, pre = null;
		//basic idea is we move the next node value to the current node, and we keep track of the previous node, so we can point the last node to null
        while(node.next != null) {
            node.val = next.val;
            pre = node;
            node = node.next;
            next = next.next;
        }
        pre.next = null;
    }
}