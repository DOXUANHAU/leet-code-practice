package node;
public class InsertionSortList {
      public ListNode insertionSortList(ListNode head) {
          if(head == null ) return null;
        
        ListNode dummy =new ListNode(0);
        ListNode current = head;
        while(current != null){
            ListNode prev = dummy;

            // find the correct location 
            while(prev.next != null || prev.next.val < current.val){
                prev = prev.next;
            }

    ListNode nextTemp = current.next; // save next node

    // insert current between prev and prev.next
    current.next = prev.next;
    prev.next = current;
    current = nextTemp; // move to next node
            
        }


        return dummy.next ;
    }
}