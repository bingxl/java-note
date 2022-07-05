package cn.bingxl.leetcode;

/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (36.75%)
 * Likes:    5301
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 2.9M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, return the longest palindromic substring in s.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "cbbd"
 * Output: "bb"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 * 
 * 
 */

import java.util.HashSet;

class LongestPalindromicSubstring5 {

    private char[] source;

    /**
     * 此方法耗时太长
     * 
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        var sLen = s.length();
        if (sLen <= 1) {
            return s;
        }
        var startIndex = 0;
        var len = 1;
        source = s.toCharArray();

        for (var start = 0; start < sLen; start++) {
            var fromIndex = start + 1;
            var searchChar = source[start];

            // 剩下的字符串中不会有比已找到的最长回文串更长的，提前结束
            // 测试用例中有个 111111111111111111111111111111111 很长的字符串，
            if (len >= sLen - start) {
                break;
            }

            do {
                var nextPosition = s.indexOf(searchChar, fromIndex);
                if (nextPosition == -1) {

                    break;
                }
                // 找到相同字符，判断他们之间是否为回文

                var isPalid = isPalindrome(start, nextPosition);

                if (isPalid && (nextPosition - start + 1) > len) {
                    startIndex = start;
                    len = nextPosition - start + 1;
                    // System.out.printf("-start: %d, nextPosition: %d, len: %d---------\n", start,
                    // nextPosition, len);

                }
                fromIndex++;
            } while (true);

        }
        return s.substring(startIndex, len + startIndex);

    }

    /**
     * 判断 souce char数组的 [from, end]字串是否为回文
     * 
     * @param from
     * @param end
     * @return
     */
    private boolean isPalindrome(int from, int end) {
        if (from > end) {
            return false;
        }

        if (from == end) {
            return true;
        }
        if (source[from] == source[end]) {
            if (from == end - 1) {
                return true;
            }
            return isPalindrome(from + 1, end - 1);

        } else {
            return false;
        }

    }

    /**
     * 动态规划解法
     * 
     * @param s
     * @return
     */
    public String dynamicPlanning(String s) {
        var logmsg = new HashSet<String>();
        logmsg.add("------------------开始处理字符串: " + s + "------------------\n");
        int len = s.length();
        if (len <= 1) {
            return s;
        }

        int start = 0;
        int maxLen = 1;
        var chars = s.toCharArray();

        var arr = new boolean[len][len];
        for (var i = 0; i < len; i++) {
            arr[i][i] = true;
        }

        // 按字串长度循环
        for (var l = 2; l <= len; l++) {

            // 左边界
            for (var i = 0; i < len; i++) {
                // 右边界 j - i + 1 = l
                var j = l + i - 1;

                // 右边越界，结束循环
                if (j >= len) {
                    break;
                }

                if (chars[i] != chars[j]) {
                    arr[i][j] = false;
                } else if (j - i < 3) {
                    // j-i+1 <= 3
                    arr[i][j] = true;
                } else {
                    // 因先按字串长度l从小到大循环，所以arr[i+1][j-1]是已经有值了
                    arr[i][j] = arr[i + 1][j - 1];
                }

                if (arr[i][j] && j - i + 1 > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
                logmsg.add(String.format("L: %d i: %d, j: %d, start: %d, maxLen: %d \n", l, i, j, start, maxLen));
            }

        }

        Util.logger.info(logmsg.toString());
        return s.substring(start, maxLen + start);
    }
}
