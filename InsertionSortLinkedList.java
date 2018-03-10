/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode cur = head;

        //break after head
        cur = cur.next;
        head.next = null;
        
        //Insert all elements from 2nd onwards into first list at sorted position
        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = null;
            
            head = insert(head, cur);
            cur = nxt;
        }
        
        return head;
    }
    
    /* Insert "node" at correct sorted position into the "list" */
    private ListNode insert(ListNode list, ListNode elem){
        if(list == null || elem == null) return elem;
        if(elem.val < list.val){    //smallest => so make it head
            elem.next = list;
            return elem;
        }
        
        ListNode head = list;
        
        while(list.next != null         //Find correct insertion point
              && elem.val > list.next.val)
            list = list.next;
        
        //insert into that position
        ListNode tmp = list.next;
        list.next = elem;
        elem.next = tmp;
        
        return head;
    }
}
