public class Solusion {
    int val;
    Solusion next;
    Solusion() {}
    Solusion(int val) { this.val = val; }
    Solusion(int val, Solusion next) { this.val = val; this.next = next; }
}
 
class Solution {
       public Solusion removeNthFromEnd(Solusion head, int n) {
        Solusion fast = head, slow = head;
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

    public String nodePrettyPrint(Solusion node){
        String result = "";
        if (node == null) {
            return result;
        }

        return result += node.val +"->" + nodePrettyPrint(node.next);
    }
    public static void main(String[] args) {
        Solusion node = new Solusion(1,new Solusion(2,new Solusion(3,new Solusion(4, new Solusion(5)))));
        
        Solution solution = new Solution();

        Solusion del = solution.removeNthFromEnd(node, 2) ;
        System.out.println(solution.nodePrettyPrint(del));
    }
}
