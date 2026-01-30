public class ADD_TWO_NUM {

    
     public ADD_TWO_NUM() {
    }

     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if( l1.val == 0 &&  l1.next == null){return l2;}
        if( l2.val == 0 && l2.next == null){return l1;}
        return recursiveNodeAdd(l1, l2 , 0);
    }
    public ListNode recursiveNodeAdd(ListNode Node_1, ListNode Node_2, int carry){
        int val_node_1 = (Node_1 != null) ? Node_1.val : 0;
        int val_node_2 = (Node_2 != null) ? Node_2.val : 0;
        int sum = val_node_1 + val_node_2 + carry;
        carry = sum / 10;
        int digit = sum % 10;


        // base case : both next nodes are null
        if(Node_1.next == null && Node_2.next == null ) return sum >= 10 ? new ListNode(digit , new ListNode(carry)) : new ListNode(digit); 


        // check for null next nodes
        if(Node_1.next == null ) return new ListNode(digit,recursiveNodeAdd(new ListNode(0), Node_2.next , carry));
        if(Node_2.next == null ) return new ListNode(digit,recursiveNodeAdd( Node_1.next, new ListNode(0) , carry));



        return new ListNode(digit,recursiveNodeAdd(Node_1.next, Node_2.next , carry));
    }
    public String prettyNodePrint(ListNode node , String result ){      
        if(node == null) return result;
        result += node.val  ;
        return  prettyNodePrint(node.next, result + " -> ") ;
    }
    public static void main(String[] args) {
        // First number: [0,8,6,5,6,8,3,5,7]
        ListNode l1 = new ListNode(0,new ListNode(8,new ListNode(6,new ListNode(5,new ListNode(6,new ListNode(8,new ListNode(3,new ListNode(5,new ListNode(7)))))))));
        // [6,7,8,0,8,5,8,9,7]
        ListNode l2 = new ListNode(6,new ListNode(7,new ListNode(8,new ListNode(0,new ListNode(8,new ListNode(5,new ListNode(8,new ListNode(9,new ListNode(7)))))))));
    ADD_TWO_NUM add_Two_Numbers = new ADD_TWO_NUM();
    ListNode node = add_Two_Numbers.addTwoNumbers(l1, l2);
    System.out.println(add_Two_Numbers.prettyNodePrint(node,""));
    }
    public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        
    }
}


