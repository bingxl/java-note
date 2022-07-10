package cn.bingxl.leetcode;
/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] ZigZag Conversion
 *
 * https://leetcode.cn/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (51.95%)
 * Likes:    1727
 * Dislikes: 0
 * Total Accepted:    454.9K
 * Total Submissions: 875.3K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "A", numRows = 1
 * Output: "A"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 * 
 * 
 */

class ZigZagConversition6 {
    public static void main(String[] args) {
        Util.logger.info(new ZigZagConversition6().solution2("PAYPALISHIRING", 4));
    }

    /**
     * 规律题,更具字符长度和给定的行数,计算每行每列字符在原始字符串中的位置即可
     * 
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        // 当行数为1时得到的就是字符串本身
        if (numRows <= 1) {
            return s;
        }
        // 以 2 * numRows - 2 为一个循环
        int zNum = 2 * numRows - 2;
        StringBuilder[] result = new StringBuilder[numRows];
        for (var i = 0; i < numRows; i++) {
            result[i] = new StringBuilder();
        }
        char[] source = s.toCharArray();
        for (var i = 0; i < source.length; i++) {
            int remaind = i % zNum;
            // 倒 N 型, 处于非 | 上的字符位置需要处理
            if (remaind >= numRows) {
                remaind = numRows - (remaind + 2) % numRows;
            }
            result[remaind].append(source[i]);

        }

        var re = "";
        for (var i = 0; i < numRows; i++) {
            re += result[i].toString();
        }
        return re;
    }

    /**
     * 按 numRows 遍历,枚举出每一行的所有索引,直接拼接字符串.
     * 
     * @param s
     * @param numRows
     * @return
     */
    public String solution2(String s, int numRows) {
        int sLen = s.length();
        // 字符串能全部排到第一行或者第一列时返回的是字符串本身.
        if (numRows > sLen || numRows == 1) {
            return s;
        }

        StringBuilder result = new StringBuilder(s.length());

        char[] source = s.toCharArray();
        int tLen = 2 * numRows - 2;
        int t = sLen / tLen;

        for (int i = 0; i < numRows; i++) {
            for (var j = 0; j <= t; j++) {
                int lindex = j * tLen + i;
                if (lindex < sLen) {
                    result.append(source[lindex]);
                    Util.logger.info(String.format("append: %c, index: %d", source[lindex], lindex));
                }
                if (i > 0 && i < numRows - 1) {
                    int index = j * tLen + tLen - i;
                    if (index < sLen) {
                        result.append(source[index]);
                        Util.logger.info(String.format("append: %c, index: %d", source[index], index));
                    }
                }

            }
        }

        return result.toString();
    }
}
