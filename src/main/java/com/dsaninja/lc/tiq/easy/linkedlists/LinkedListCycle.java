package com.dsaninja.lc.tiq.easy.linkedlists;

import com.dsaninja.lc.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given head, the head of a linked list, determine if the
 * linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in
 * the list that can be reached again by continuously following
 * the next pointer. Internally, pos is used to denote the index of
 * the node that tail's next pointer is connected to. Note that pos
 * is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * <p>
 * <a href="https://leetcode.com/problems/linked-list-cycle/">Problem-141</a>
 */
public class LinkedListCycle{

    public boolean hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(null != fast && null != fast.next){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    @Test
    @DisplayName("test cycle presence in a linked list")
    public void testCycle(){
        ListNode one = new ListNode(4);
        ListNode two = new ListNode(5);
        ListNode three = new ListNode(1);
        ListNode four = new ListNode(9);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;
        assertTrue(hasCycle(one));

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;
        assertFalse(hasCycle(one));
    }
}
