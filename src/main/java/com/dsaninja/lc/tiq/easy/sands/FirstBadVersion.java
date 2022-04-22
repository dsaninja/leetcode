package com.dsaninja.lc.tiq.easy.sands;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check. Since
 * each version is developed based on the previous version, all the versions after a
 * bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of
 * calls to the API.
 * <p>
 *
 * <a href="https://leetcode.com/problems/first-bad-version/">Problem-278</a>
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        int result = n;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (isBadVersion(mid)) {
                result = mid;
                end = mid;
            }else{
                start = mid+1;
            }
        }

        return result;
    }

    // given implementation
    private boolean isBadVersion(int mid) {
        return false;
    }
}
