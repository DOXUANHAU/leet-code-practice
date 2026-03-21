package listnode;
import node.*;

class Solusion {
       public Node removeNthFromEnd(Node head, int n) {
        Node fast = head, slow = head;
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

        return head;
    }

    /**
     * @param node
     * @return
     */
    public String nodePrettyPrint(Node node){
        String result = "";
        if (node == null) {
            return result;
        }

        return result += node.val +"->" + nodePrettyPrint(node.next);
    }
    public static void main(String[] args) {
        Node node = new Node(1,new Node(2,new Node(3,new Node(4, new Node(5)))));
        
        Solusion solution = new Solusion();

        Node del = solution.removeNthFromEnd(node, 2) ;
        System.out.println(solution.nodePrettyPrint(del));
    }
}
