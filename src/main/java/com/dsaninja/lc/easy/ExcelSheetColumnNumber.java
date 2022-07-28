package com.dsaninja.lc.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a string columnTitle that represents the column title as
 * appears in an Excel sheet, return its corresponding column number.
 * <p>
 * <a href="https://leetcode.com/problems/excel-sheet-column-number/">Problem-171</a>
 */
public class ExcelSheetColumnNumber{
    public int titleToNumber(String columnTitle){
        int number = 0;
        for(char c : columnTitle.toCharArray()){
            if(number != 0){
                number*= 26;
            }

            number += c - 'A' + 1;
        }

        return number;
    }

    @Test
    public void testTitleToNumber(){
        assertEquals(1, titleToNumber("A"));
        assertEquals(2, titleToNumber("B"));
        assertEquals(26, titleToNumber("Z"));

        assertEquals(27, titleToNumber("AA"));
        assertEquals(54, titleToNumber("BB"));
        assertEquals(702, titleToNumber("ZZ"));
    }
}
