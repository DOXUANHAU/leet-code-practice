package listnode;



public class MergeSortList {
     // Hàm in list
    public void printList(ListNode head){
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        // 1. Tìm middle
        ListNode mid = getMiddle(head);
        ListNode right = mid.next;
        mid.next = null; // cắt list làm 2

        // 2. Sort từng nửa
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(right);

        // 3. Merge 2 nửa đã sort
        return merge(leftSorted, rightSorted);
    }

    // Hàm merge 2 list đã sort
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Gắn phần còn lại
        if(l1 != null) tail.next = l1;
        if(l2 != null) tail.next = l2;

        return dummy.next;
    }

    // Hàm tìm middle (slow-fast pointer)
    private ListNode getMiddle(ListNode head){
        if(head == null) return head;
        ListNode slow = head;
        ListNode fast = head.next; // chú ý start fast = head.next

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
      public static void main(String[] args){
        MergeSortList sorter = new MergeSortList();

        // Tạo linked list: 7 → 2 → 9 → 1 → 5 → 3 → 8 → 4
        ListNode head = new ListNode(7);
        head.next = new ListNode(2);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next = new ListNode(4);

        System.out.println("Before sort:");
        sorter.printList(head);

        head = sorter.sortList(head);

        System.out.println("After sort:");
        sorter.printList(head);
    }
}
