package com.dsaninja.lc.tiq.easy.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidPalindrome{
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z') || (c  >= '0' && c <= '9')) {
                builder.append(c);
            } else if((c >= 'A' && c <= 'Z')) {
                builder.append(Character.toLowerCase(c));
            }
        }

        int start = 0;
        int end = builder.length()-1;

        while(start < end) {
            if(builder.charAt(start++) != builder.charAt(end--)) {
                return false;
            }
        }

        return true;
    }

    @Test
    @DisplayName("test a valid palindrome with special characters")
    public void testPalindrome(){
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
