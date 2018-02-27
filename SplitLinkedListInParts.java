/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode curHead;
    int nextPiece;
    public ListNode[] splitListToParts(ListNode root, int k) {
        curHead = root;
        int listSize = 0;
        
        while(root != null){ root = root.next; listSize++; }
        
        int numOfPieces = k;
        ListNode[] res = new ListNode[k];
        while(numOfPieces > 0){
            res[k-numOfPieces] = next(listSize, numOfPieces);
            listSize-=nextPiece;
            numOfPieces--; 
        }
        
        return res;
    }
    
    //return next list of desired size
    private ListNode next(int N, int k){
        nextPiece = (int) Math.ceil((double)N/k);
        ListNode res = curHead, prev = null;
        for(int i=0; i<nextPiece && curHead!=null; i++){
            prev = curHead;
            curHead = curHead.next;
        }
        if(prev!=null) prev.next = null;
        return res;
    }
}
