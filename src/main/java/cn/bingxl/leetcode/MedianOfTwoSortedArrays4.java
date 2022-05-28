package cn.bingxl.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * [4] 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 
 * @author bingxl<bingxl@outlook.com>
 * 
 */
public class MedianOfTwoSortedArrays4 {
    /**
     * 合并后排序在找中位数
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    double mergeAndSort(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] nums = new int[len];
        int offset = 0;
        for (int num : nums1) {
            Array.set(nums, offset++, num);
        }
        for (int num : nums2) {
            Array.set(nums, offset++, num);
        }
        Arrays.sort(nums);

        int halfPos = len / 2;
        boolean isEven = len % 2 == 0;

        if (isEven) {
            return (nums[halfPos - 1] + nums[halfPos]) / 2.0;
        } else {
            return (double) nums[halfPos];
        }
    }
}
