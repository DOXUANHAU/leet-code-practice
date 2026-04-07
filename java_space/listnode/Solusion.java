package listnode;
import node.*;

class Solusion {
       public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        // move to n from head 
        for (int i = 0; i < n; i++) fast = fast.next; 

        if (fast == null) return head.next;

        // move to end of the list after that the slow ListNode will at the right position to delete 
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // delete 
        slow.next = slow.next.next;

        return head;
    }

    /**
     * @param ListNode
     * @return
     */
    public String ListNodePrettyPrint(ListNode ListNode){
        String result = "";
        if (ListNode == null) {
            return result;
        }

        return result += ListNode.val +"->" + ListNodePrettyPrint(ListNode.next);
    }
    public static void main(String[] args) {
        ListNode ListNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4, new ListNode(5)))));
        
        Solusion solution = new Solusion();

        ListNode del = solution.removeNthFromEnd(node, 2) ;
        System.out.println(solution.nodePrettyPrint(del));
    }
}
