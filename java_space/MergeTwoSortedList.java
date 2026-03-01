
public class MergeTwoSortedList{
public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 


     public String nodePrettyPrint(ListNode node){
        String result = "";
        if (node == null) {
            return result;
        }

        return result += node.val +" -> " + nodePrettyPrint(node.next);
    }
   
 public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    if(list1== null) return list2;
    if(list2 == null) return list1;

    // check current value 
    if (list1.val < list2.val) {
    list1.next = mergeTwoLists(list1.next, list2);
    return list1;
    } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode node_2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        MergeTwoSortedList  list = new MergeTwoSortedList();
        System.out.println(list.nodePrettyPrint(list.mergeTwoLists(node_1, node_2)));

    }
}
