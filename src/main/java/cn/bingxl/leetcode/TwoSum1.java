package cn.bingxl.leetcode;

/**
 * [1] 两数之和
 * https://leetcode-cn.com/problems/two-sum/description/
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 
 * @author bingxl<bingxl@outlook.com>
 */

import java.util.HashMap;

public class TwoSum1 {
    /**
     * description 暴力破解 T O(n^2) S O(1)
     */
    public int[] solution1(int[] nums, int target) throws IllegalArgumentException {
        int remainder;
        for (int i = 0; i < nums.length - 1; i++) {
            remainder = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == remainder) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("no two element in array to sum is target");
    }

    /**
     * 使用 hash 存储查找， T O(n); S O(n)
     */

    public int[] solution2(int[] nums, int target) throws IllegalArgumentException {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        int remainder;
        for (int i = 0; i < nums.length; i++) {
            remainder = target - nums[i];

            // 查找的值要和put进去的值配套，如果查找nums[i]则后面put进去的应该是remainder
            if (map.containsKey(remainder)) {
                return new int[] { map.get(remainder), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("nums中没有满足和为target的两个元素");
    }
}
