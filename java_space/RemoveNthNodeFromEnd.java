public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
       public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        // move to n from head 
        for (int i = 0; i < n; i++) fast = fast.next; 

        if (fast == null) return head.next;

        // move to end of the list after that the slow node will at the right position to delete 
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // delete 
        slow.next = slow.next.next;

        // return head cause  slow and head are reference to one object in heap 
        return head;
    }

    public String nodePrettyPrint(ListNode node){
        String result = "";
        if (node == null) {
            return result;
        }

        return result += node.val +"->" + nodePrettyPrint(node.next);
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4, new ListNode(5)))));
        
        Solution solution = new Solution();

        ListNode del = solution.removeNthFromEnd(node, 2) ;
        System.out.println(solution.nodePrettyPrint(del));
    }
}
