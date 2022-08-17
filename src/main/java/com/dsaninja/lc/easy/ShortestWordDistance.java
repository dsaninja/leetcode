package com.dsaninja.lc.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an array of strings wordsDict and two different strings
 * that already exist in the array word1 and word2, return the
 * shortest distance between these two words in the list.
 *
 * <pre>
 *      Input:
 *      wordsDict = ["practice", "makes", "perfect", "coding", "makes"],
 *      word1 = "coding", word2 = "practice"
 *      Output: 3
 * </pre>
 *
 * <a href="https://leetcode.com/problems/shortest-word-distance/">Problem-243</a>
 */
public class ShortestWordDistance{
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int indexOne = Integer.MIN_VALUE;
        int indexTwo = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < wordsDict.length; i++){
            if(wordsDict[i].equalsIgnoreCase(word1)){
                indexOne = i;
            }

            else if(wordsDict[i].equalsIgnoreCase(word2)){
                indexTwo = i;
            }

            if(indexTwo != Integer.MIN_VALUE && indexOne != Integer.MIN_VALUE){
                min = Math.min(min, Math.abs(indexTwo - indexOne));
            }
        }

        return min;
    }

    @Test
    public void testShortestDistance(){
        assertEquals(3,
                shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                        "coding",
                        "practice"));
        assertEquals(1,
                shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                        "makes",
                        "coding"));
    }
}
