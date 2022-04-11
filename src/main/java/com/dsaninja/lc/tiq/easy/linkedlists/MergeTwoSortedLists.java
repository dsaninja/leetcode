package com.dsaninja.lc.tiq.easy.linkedlists;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MergeTwoSortedLists {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode itr = dummy;

        while (null != list1 && null != list2){
            if(list1.val < list2.val){
                itr.next = list1;
                list1 = list1.next;
            }else{
                itr.next = list2;
                list2 = list2.next;
            }
            itr = itr.next;
        }

        if(null == list1){
            itr.next = list2;
        }

        if(null == list2){
            itr.next = list1;
        }

        return dummy.next;
    }

    @Test
    @DisplayName("test merging two sorted lists")
    public void testMergingLists(){
        ListNode one = new ListNode(6);
        ListNode two = new ListNode(20);

        ListNode three = new ListNode(3);
        ListNode four = new ListNode(11);

        one.next = two; two.next = null;
        three.next = four; four.next = null;

        ListNode result = mergeTwoLists(one, three);
        assertEquals(3, result.val);
        assertEquals(6, result.next.val);
        assertEquals(11, result.next.next.val);
        assertEquals(20, result.next.next.next.val);
        assertNull(result.next.next.next.next);

    }
}
