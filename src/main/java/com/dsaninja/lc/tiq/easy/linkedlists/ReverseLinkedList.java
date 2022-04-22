package com.dsaninja.lc.tiq.easy.linkedlists;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 *
 * <a href="https://leetcode.com/problems/reverse-linked-list/">Problem-206</a>
 */
public class ReverseLinkedList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(null == head || null == head.next){
            return head;
        }

        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    @Test
    @DisplayName("test reversing a singly linked list")
    public void testDeletion(){
        ListNode one = new ListNode(4);
        ListNode two = new ListNode(5);
        ListNode three = new ListNode(1);
        ListNode four = new ListNode(9);

        one.next = two; two.next = three; three.next = four; four.next = null;

        reverseList(one);
        assertEquals(three.val, four.next.val);
        assertEquals(two.val, three.next.val);
        assertEquals(one.val, two.next.val);
        assertNull(one.next);


    }

}
