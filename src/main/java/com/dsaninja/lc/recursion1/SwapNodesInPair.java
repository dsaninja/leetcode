package com.dsaninja.lc.recursion1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">Problem-24</a>
 */
public class SwapNodesInPair{

    //O(n)
    public ListNode swapPairs(ListNode head){
        if(null == head || null == head.next){
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

    @Test
    public void testPairsSwap(){
       ListNode head = new ListNode(1);
       ListNode two = new ListNode(2);
       ListNode three = new ListNode(3);
       ListNode four = new ListNode(4);

       head.next = two;
       two.next = three;
       three.next = four;

       ListNode result = swapPairs(head);

       assertEquals(2, result.val);
       assertEquals(1, result.next.val);
       assertEquals(4, result.next.next.val);
       assertEquals(3, result.next.next.next.val);
    }


    public class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }
}
