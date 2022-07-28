package com.dsaninja.lc.easy;

/**
 * Given a file and assume that you can only read the file
 * using a given method read4, implement a method to read n
 * characters.
 *
 * <a href="https://leetcode.com/problems/read-n-characters-given-read4/">Problem-157</a>
 */
public class ReadNChar{
    private int read4(char[] buff){
        // this method is given to be implemented
        return  -1;
    }

    public int read(char[] buf, int n) {
        int start = 0, charactersRead = 0;
        char[] buf4 = new char[4];

        do{
            charactersRead = read4(buf4);
            // Read until there are enough characters from read4
            // or enough space in buffer.
            for(int i=0; i < charactersRead && n > 0; i++){
                buf[start++] = buf4[i];
                n--;
            }
        }while(charactersRead !=0 && n !=0);

        return start;
    }
}
