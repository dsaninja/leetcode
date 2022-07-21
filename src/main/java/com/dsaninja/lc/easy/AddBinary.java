package com.dsaninja.lc.easy;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * <a href="https://leetcode.com/problems/add-binary/">Problem-67</a>
 */
public class AddBinary{

    public String addBinary(String a, String b){
        int lengthOne = a.length(), lengthTwo = b.length();

        // always run on longer string
        if(lengthOne < lengthTwo){
            return addBinary(b, a);
        }

        StringBuilder sb = new StringBuilder();
        int sum = 0, j = lengthTwo - 1;

        // start from the end of longer string
        // i.e. the least significant bit
        for(int i = lengthOne - 1; i > -1; --i, j--){
            if(a.charAt(i) == '1') {
                ++sum;
            }

            if(j > -1 && b.charAt(j) == '1') {
                ++sum;
            }

            if(sum % 2 == 1) {
                sb.append('1');
            }

            else {
                sb.append('0');
            }

            sum /= 2;
        }

        if(sum == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}
