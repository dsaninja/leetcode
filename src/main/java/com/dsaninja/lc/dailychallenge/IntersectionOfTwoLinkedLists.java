package com.dsaninja.lc.dailychallenge;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no
 * intersection at all, return null.
 *
 * <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Problem-160</a>
 */
public class IntersectionOfTwoLinkedLists{

    public class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            val = x;
            next = null;
        }
    }

    /**
     * The same can be implemented by following steps:
     *
     * <ol>
     *     <li>Get the two list lengths</li>
     *     <li>Move the longer list fwd by the diff umber of steps</li>
     *     <li>Now move both the lists together</li>
     *     <li>Anytime they point to same node, is the intersection point</li>
     * </ol>
     *
     * @param headA start of list 1
     * @param headB start of list 2
     * @return intersection point
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){

        if(null == headA || null == headB){
            return null;
        }

        int listALength = calculateLength(headA);
        int listBLength = calculateLength(headB);

        if(listALength > listBLength){
            headA = moveFwd(headA, listALength - listBLength);
        } else if(listBLength > listALength){
            headB = moveFwd(headB, listBLength - listALength);
        }

        while(null != headA && null != headB){
            if(headA == headB){
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int calculateLength(ListNode node){
        int length = 0;
        while(null != node){
            node = node.next;
            length++;
        }

        return length;
    }

    private ListNode moveFwd(ListNode node, int slots){
        for(int i = 1; i <= slots; i++){
            node = node.next;
        }

        return node;
    }
}
