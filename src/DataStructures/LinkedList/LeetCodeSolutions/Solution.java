package DataStructures.LinkedList.LeetCodeSolutions;

import java.util.HashSet;

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr != null) {
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
        if (head == null || head.next == null) {
            return false;
        }

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

    // using hash set
    public boolean hasCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return true;
            }

            set.add(head);
            head = head.next;
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
        ListNode head = list; // return the head when done

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


    /**
     * Given the head of a linked list and an integer val,
     * remove all the nodes of the linked list that has Node.val == val, and return the new head.
     */
    // modify the list in place
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode list = new ListNode();
        list.next = head; // point the currently empty node at the head, this allows you to remove the head node
        ListNode cur = list; // now points to same list as "head", but with a next pointer at the head

        while (cur.next != null) {
            if (cur.next.val == val) { // have to check against next value without a prev pointer
                cur.next = cur.next.next; // remove the that value by skipping over it
            } else {
                cur = cur.next; // increment to the next node
            }
        }

        return list.next; // have to return next as first node is placement holder
    }

    // modify the list in place, two pointers method
    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode list = new ListNode();
        list.next = head; // point the currently empty node at the head, this allows you to remove the head node
        ListNode cur = head; // same as head list // 1 node ahead of list
        ListNode prev = list; // now points to same list as "head", but with a next pointer at the head

        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next; // remove the that value by skipping over it
            } else {
                prev = prev.next; // increment to the next node
            }
            cur = cur.next; // increment to the next node
        }

        return list.next; // have to return next as first node is placement holder
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }





    public static void main(String[] args) {
        ListNode list = new ListNode(1); // head
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        ListNode list6 = new ListNode(6);
        ListNode list7 = new ListNode(7); // tail

        list.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list6;
        list6.next = list7;
        list7.next = null;

    }


}
