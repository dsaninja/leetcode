package com.dsaninja.lc.tiq.easy.linkedlists;

import com.dsaninja.lc.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Write a function to delete a node in a singly-linked list.
 * You will not be given access to the head of the list, instead you
 * will be given access to the node to be deleted directly.
 * <p>
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 * <p>
 *
 * <a href="https://leetcode.com/problems/delete-node-in-a-linked-list/">Problem-237</a>
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while (null != node && null != node.next){
            prev = node;
            node.val = node.next.val;
            node = node.next;
        }
        prev.next = null;
    }

    @Test
    @DisplayName("test deleting a node from a single linked list")
    public void testDeletion(){
        ListNode one = new ListNode(4);
        ListNode two = new ListNode(5);
        ListNode three = new ListNode(1);
        ListNode four = new ListNode(9);

        one.next = two; two.next = three; three.next = four; four.next = null;

        deleteNode(two);
        assertEquals(1, one.next.val);
        assertNull(three.next);
    }
}
