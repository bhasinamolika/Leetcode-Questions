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
        node.val=node.next.val;
        node.next=node.next.next;
        
    }
}