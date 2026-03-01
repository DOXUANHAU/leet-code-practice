public class ReverseNodesInKGroup{
       public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

     public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null || head.next == null ) return head;
        ListNode tail = head;

        // move to the last node in the k group
        for(int i = 0; i < k - 1; i++){
            tail = tail.next;
            if(tail == null) return head;
        }
      
      
 ListNode prev = reverseKGroup(tail.next, k);
    ListNode curr = head;

    for (int i = 0; i < k; i++) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    return prev;
    }
    
public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);
    head.next.next.next.next.next.next.next.next = new ListNode(9);

    ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
    ListNode result = solution.reverseKGroup(head, 3);
// print  
    while (result != null) {
        System.out.print(result.val + " ");
        result = result.next;
    }
}
}