package com.dsaninja.lc.tiq.easy.linkedlists;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given the head of a linked list, remove the nth node from
 * the end of the list and return its head.
 * <p>
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/
 */
public class RemoveNthNodeFromEnd {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // the dummy node approach is specially useful for single node
        // no node or last node deletion scenarios
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        for(int i = 0 ; i <=n ;i++){
            fast = fast.next;
        }

        // will fast is beyond last node i.e. pointing to null
        // slow is 1 behind nth node
        while (null != fast){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    @Test
    @DisplayName("test removing 2nd last node from a singly linked list")
    public void testDeletion(){
        ListNode one = new ListNode(4);
        ListNode two = new ListNode(5);
        ListNode three = new ListNode(1);
        ListNode four = new ListNode(9);

        one.next = two; two.next = three; three.next = four; four.next = null;

        removeNthFromEnd(one, 2);

        assertEquals(9, two.next.val);
    }

}
