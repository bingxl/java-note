package cn.bingxl.leetcode;

/**
 * [3] 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * @author bingxl<bingxl@outlook.com>
 */

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters3 {
    /**
     * 双指针法，查找下一个字符在头指针和尾指针之间是否存在，存在则头指针跳到重复字符的下一个
     * 
     * @param s
     * @return
     */
    int solution1(String s) {
        int max = 0;
        int len = s.length();
        int head = 0;
        int tail = 1;
        if (len <= 1) {
            return len;
        }

        while (tail < len) {

            int index = s.indexOf(s.charAt(tail), head);
            // System.out.println(head + "," + tail + ":" + index);
            if (index != -1 && index < tail) {
                max = Math.max(max, tail - head);
                head = index + 1;
            } else {
                if (tail == len - 1) {
                    max = Math.max(max, tail - head + 1);
                }
                tail++;
            }
            if (head == tail) {
                // 防止 bb这种出现后原地踏步
                tail++;
            }
        }

        return max;
    }

    /**
     * 滑窗法
     * 
     * @param s
     * @return
     */
    int solution2(String s) {

        int max = 0;
        int len = s.length();

        HashSet<Character> set = new HashSet<Character>();

        int rp = 0;
        for (int lp = 0; lp < len; lp++) {

            // set中不含右指针指向的字符则将右指针指向的字符添加到set，同时右指针不断向右移动知道字符串结束
            while (rp < len && !set.contains(s.charAt(rp))) {
                set.add(s.charAt(rp));
                System.out.println(set);
                rp++;
            }
            max = Math.max(max, set.size());
            // 遇到重复字符或者右指针已移到字符串结尾，左指针向右移动一位
            // 特别注意，只移动一位，不能直接移动到重复位的下一位，因为要将重复位及之前的字符从set中删除
            // 继续优化：当rp==len时可以 break for 循环
            set.remove(s.charAt(lp));
        }

        return max;
    }

}