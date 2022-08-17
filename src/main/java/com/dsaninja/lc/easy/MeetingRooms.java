package com.dsaninja.lc.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given an array of meeting time intervals where intervals[i] = [starti, endi],
 * determine if a person could attend all meetings.
 *
 * <a href="https://leetcode.com/problems/meeting-rooms/">Problem-252</a>
 */
public class MeetingRooms{

    public boolean canAttendMeetings(int[][] intervals){
        // sort on end times
        Arrays.sort(intervals, Comparator.comparingInt(array -> array[1]));


        for(int i = 1; i < intervals.length; i++){
            // check if start of ith is less than end of i-1th
            // return false then
            if(intervals[i][0] < intervals[i - 1][1]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void testCanAttend(){
        assertTrue(canAttendMeetings(new int[][]{{7, 10}, {2, 4}}));
        assertFalse(canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
    }
}
