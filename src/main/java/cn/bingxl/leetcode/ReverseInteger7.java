/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.cn/problems/reverse-integer/description/
 *
 * algorithms
 * Medium (35.37%)
 * Likes:    3598
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 3M
 * Testcase Example:  '123'
 *
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-2^31, 2^31 - 1], then return 0.
 * 
 * Assume the environment does not allow you to store 64-bit integers (signed
 * or unsigned).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: x = 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: x = 120
 * Output: 21
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= x <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
package cn.bingxl.leetcode;

class ReverseInteger7 {

    /**
     * int 反转
     * 将 int 转换为字符串，将字符串反转后判断是否溢出
     * 
     * @param x
     * @return
     */
    public int reverse(int x) {
        // -2147483648 <= Integer <= 2147483647
        // Integer最高位10进制的第十位
        var maxlen = 10;
        var maxBase = (int) Math.pow(10.0, 9.0);

        var isPostive = x >= 0 ? true : false;

        var s = new StringBuilder(
                int2s(
                        Math.abs(x)))
                .reverse();

        //
        if (s.length() >= maxlen) {
            var sFirst = s2int(s.substring(0, 1));
            var maxFirst = 2;
            if (sFirst > maxFirst) {
                return 0;
            } else if (sFirst == maxFirst) {
                int sRemain = Integer.parseInt(s, 1, s.length(), 10);
                int maxRemain = Integer.MAX_VALUE % maxBase;
                var minRemain = Math.abs(Integer.MIN_VALUE % maxBase);
                Util.logger.info(
                        String.format("sR: %d, maxR: %d, minR: %d, maxBase: %d",
                                sRemain,
                                maxRemain,
                                minRemain,
                                maxBase));
                var overflower = isPostive ? (sRemain > maxRemain ? true : false)
                        : (sRemain > minRemain ? true : false);
                if (overflower) {
                    return 0;
                }
            }
        }

        return Integer.parseInt((isPostive ? "" : "-") + s);
    }

    private String int2s(int x) {
        return Integer.toString(x);
    }

    private int s2int(String s) {
        return Integer.decode(s);
    }
}
// @lc code=end
