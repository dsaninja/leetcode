package com.dsaninja.lc.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible,
 * keep answer[i] == 0 instead.
 *
 * <a href="https://leetcode.com/problems/daily-temperatures/">Problem-739</a>
 */
public class DailyTemperature {

    @Test
    @DisplayName("test daily temp check with stack")
    public void testDailyTemp(){
        assertArrayEquals(new int[]{1,1,4,2,1,1,0,0}, dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        assertArrayEquals(new int[]{1,1,1,0}, dailyTemperatures(new int[]{30,40,50,60}));
        assertArrayEquals(new int[]{1,1,0}, dailyTemperatures(new int[]{30,60,90}));
    }

    @Test
    @DisplayName("test daily temp check with BF")
    public void testDailyTempBF(){
        assertArrayEquals(new int[]{1,1,4,2,1,1,0,0}, dailyTemperaturesBruteForce(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        assertArrayEquals(new int[]{1,1,1,0}, dailyTemperaturesBruteForce(new int[]{30,40,50,60}));
        assertArrayEquals(new int[]{1,1,0}, dailyTemperaturesBruteForce(new int[]{30,60,90}));
    }


    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> temp = new Stack<>();

        for(int index = 0; index < temperatures.length; index++){
            while(!temp.isEmpty() && temperatures[index] > temperatures[temp.peek()]){
                int idx = temp.pop();
                result[idx] = index-idx;
            }
            temp.push(index);
        }
        return result;
    }

    public int[] dailyTemperaturesBruteForce(int[] temperatures) {
        int[] waitDays = new int[temperatures.length];

        for(int i=0; i <temperatures.length-1; i++){
            int count = 0;
            boolean found= false;
            for(int j=i+1; j <temperatures.length; j++){
                if(temperatures[i] >= temperatures[j]){
                    count++;
                }else{
                    count++;
                    found = true;
                    break;
                }
            }
            if(found){
                waitDays[i] = count;
            }
        }

        return waitDays;
    }
}
