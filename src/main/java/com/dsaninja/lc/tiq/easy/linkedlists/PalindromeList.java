package com.dsaninja.lc.tiq.easy.linkedlists;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">Problem-234</a>
 */
public class PalindromeList{

    private static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }

    ListNode front;

    public boolean isPalindrome(ListNode head){
        front = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode){
        if(null != currentNode){
            // if next section is not palindrome, return false
            if(!recursivelyCheck(currentNode.next)){
                return false;
            }

            // if current and front don't match, return false
            if(currentNode.val != front.val){
                return false;
            }
            front = front.next;
        }

        // if beyond last node, return true
        return true;
    }

    @Test
    @DisplayName("test palindrome list")
    public void testPalindrome(){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(1);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;

        assertTrue(isPalindrome(one));
    }
}
