/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
   public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) return null;
        int start = 0;
        int end = lists.length - 1;
        int j = end;
while(end != 0){
    start = 0;
    j = end;
    while (j > start ) {
        lists[start] = mergeTwoLists(lists[start], lists[j]);
        start ++;
        j--;
        end = j;
    }
}
       
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    if(list1== null) return list2;
    if(list2 == null) return list1;
    if(list1 == null && list2 == null) return null;

    // check current value 
    if (list1.val < list2.val) {
    list1.next = mergeTwoLists(list1.next, list2);
    return list1;
    } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
