/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (36.70%)
 * Likes:    5157
 * Dislikes: 0
 * Total Accepted:    889.3K
 * Total Submissions: 2.4M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 * 示例 4:
 * 
 * 
 * 输入: s = ""
 * 输出: 0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * s 由英文字母、数字、符号和空格组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int sLen = s.length();
        HashMap<String, Integer> collection = new HashMap(sLen);

        int max = 1;
        if (sLen == 0 || sLen == 1) {
            return sLen;
        }

        int preIndex = 0;
        int j = 1;
        while (j < sLen) {

            int index = s.indexOf(s.charAt(j), preIndex);
            String preChar = collection.get(s.charAt(j));
            if (preChar == null) {
                collection.put(s.charAt(j), j);
                j++;
                continue;
            }

            if (index >= preIndex && index < j) {
                // 有重复字符,前指针移动到重复字符后一位
                max = Math.max(max, j - preIndex);
                System.out.println(String.format("preIndex: %d, afterIndex: %d, 重复字符索引: %d", preIndex, j, index));
                preIndex = index + 1;

            } else if (j == sLen - 1) {
                // 没有重复,且后指针已到字符串结尾
                max = Math.max(max, sLen - preIndex);
            }
            j++;
        }
        return max;
    }
}
// @lc code=end
