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

}
