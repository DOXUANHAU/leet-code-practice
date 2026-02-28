import java.util.List;

public class SwapNodesinPairs{
     public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        
    }
     public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null) return head;
        // create first node for swap two adjacent nodes
        ListNode first = new ListNode(head.next.val);

        // recursive for the second . next node cause the same action for next.next node from swap location node 
        head.next = swapPairs(head.next.next);
        
        //the current node gonna add two first node;
        first.next = head;
                
        return first;   
    }
    public static void main(String[] args) {
        
    }
}