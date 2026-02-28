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

        ListNode  temp = head.next.next;
        ListNode first = new ListNode(head.next.val);
        head.next = swapPairs(temp);
        first.next = head;
        return first;   
    }
}