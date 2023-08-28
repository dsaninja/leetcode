package com.dsaninja.lc.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons)
 * is given below. Note that 1 does not map to any letters.
 *
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">Problem-17</a>
 * <a href="https://www.youtube.com/watch?v=vgnhZzw-kfU">Reference</a>
 */
public class PhoneNumberChars {

    @Test
    @DisplayName("test the phone numbers for digits")
    public void test(){
        assertEquals(List.of("ad","ae","af","bd","be","bf","cd","ce","cf"), letterCombinations("23"));
        assertEquals(List.of(), letterCombinations(""));
        assertEquals(List.of("a","b","c"), letterCombinations("2"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()){
            return result;
        }

        Map<String, String> mappings = Map.of("2", "abc",
                "3", "def",
                "4", "ghi",
                "5", "jkl",
                "6", "mno",
                "7", "pqrs",
                "8", "tuv",
                "9", "wxyz"
        );
        solve(digits, 0, result, new StringBuilder(), mappings);
        return result;
    }

    public void solve(String digits,
                      int index,
                      List<String> result,
                      StringBuilder temp,
                      Map<String, String> mappings){
        if(index >= digits.length()){
            result.add(temp.toString());
            return;
        }

        // abc; def
        String currentSet = mappings.get(String.valueOf(digits.charAt(index)));

        for(int i=0; i < currentSet.length(); i++){
            temp.append(currentSet.charAt(i));
            solve(digits, index+1, result, temp, mappings);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
