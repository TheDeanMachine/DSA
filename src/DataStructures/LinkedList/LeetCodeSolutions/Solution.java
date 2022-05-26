package DataStructures.LinkedList.LeetCodeSolutions;

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     * There is a cycle in a linked list if there is some node in the list that can be
     * reached again by continuously following the next pointer
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    /**
     * You are given the heads of two sorted linked lists list1 and list2.
     * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
     * Return the head of the merged linked list.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        ListNode list = new ListNode();
        ListNode head = list;

        while(list1 != null && list2 != null) { // stops when either list next gets to null
            if (list1.val <= list2.val) {
                list.next = list1;  // assign value to list
                list1 = list1.next; // increment to next pointer
            } else {
                list.next = list2;  // assign value to list
                list2 = list2.next; // increment to next pointer
            }

            list = list.next; // increment to next pointer
        }

        // add the last value to the end
        if(list1 == null) {
            list.next = list2;
        } else {
            list.next = list1;
        }
        return head.next;
    }




}
