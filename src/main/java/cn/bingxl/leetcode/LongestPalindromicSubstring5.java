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
        var palindromicString = s.substring(0, 1);

        for (var start = 0; start < sLen; start++) {
            var fromIndex = start + 1;
            var searchChar = s.charAt(start);
            System.out.printf("start: %d, fromIndex: %d, char: %c, curMax: %s \n", start, fromIndex, searchChar,
                    palindromicString);
            do {
                var nextPosition = s.indexOf(searchChar, fromIndex);
                if (nextPosition == -1) {

                    break;
                }
                // 找到相同字符，判断他们之间是否为回文
                var substr = s.substring(start, nextPosition + 1);
                var reverseStr = new StringBuffer(substr).reverse().toString();
                System.out.printf("--------subStr: %s ---------\n", substr);
                if (substr.equals(reverseStr) && substr.length() >= palindromicString.length()) {
                    palindromicString = substr;
                    System.out.printf("当前最大回文串： %s\n", substr);
                }
                fromIndex++;
            } while (true);

        }
        return palindromicString;

    }
}
