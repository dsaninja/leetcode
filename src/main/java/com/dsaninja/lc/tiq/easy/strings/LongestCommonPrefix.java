package com.dsaninja.lc.tiq.easy.strings;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a function to find the longest common prefix
 * string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * <a href="https://leetcode.com/problems/longest-common-prefix/">Problem-14</a>
 */
public class LongestCommonPrefix{

    /**
     * O(mn) where n is the total strings in array and m is
     * average string length
     *
     * @param strs input array
     * @return common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // let's assume first string is common to all
        String prefix = strs[0];

        // for rest of the string
        for(int i = 1; i < strs.length; i++){
            // check if every string starts with prefix
            while(strs[i].indexOf(prefix) != 0){
                // if not, trim the prefix from end by 1
                prefix = prefix.substring(0, prefix.length() - 1);
            }

            // if prefix is all trimmed up
            if(prefix.length() == 0){
                // return blank string
                return "";
            }
        }

        // return prefix which is common to
        // all strings
        return prefix;
    }

    @Test
    public void testLongestPrefix(){
        assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "float", "flight"}));
        assertEquals("a", longestCommonPrefix(new String[]{"ab", "a"}));
    }
}
