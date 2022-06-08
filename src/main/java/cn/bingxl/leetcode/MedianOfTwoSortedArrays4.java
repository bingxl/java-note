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

    /**
     * 分别遍历两个数组寻找中位数
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    double linkSorted(int[] nums1, int[] nums2) {
        System.out.println("=========================================");
        System.out.printf("num1s: %s, nums2: %s\n", Arrays.toString(nums1), Arrays.toString(nums2));

        var len = (nums1.length + nums2.length);
        var halfPosition = len / 2;
        var isEven = len % 2 == 0;
        var sum = 0.0;
        var num1Point = 0;
        var num2Point = 0;
        var curIndex = 0;

        while (num1Point < nums1.length || num2Point < nums2.length) {
            System.out.printf("num1Point: %d num2Point: %d\n", num1Point, num2Point);

            var curValue = 0;
            // 有一组数组遍历完了就另一组索引加1， 否则当前相对小的一组索引＋1
            if (num1Point >= nums1.length) {
                curValue = nums2[num2Point];
                num2Point++;
            } else if (num2Point >= nums2.length) {
                curValue = nums1[num1Point];
                num1Point++;
            }
            // nums1 nums2 的值一定要在判断索引是否超出边界后在用
            else if (nums1[num1Point] <= nums2[num2Point]) {
                curValue = nums1[num1Point];
                num1Point++;
            } else {
                curValue = nums2[num2Point];
                num2Point++;
            }

            // 判断当前curIndex是否为half位置
            if (isEven && curIndex == halfPosition - 1) {
                sum += curValue;
            }
            if (curIndex == halfPosition) {
                // 中位数已全部找到，结束循环
                sum += curValue;
                break;
            }

            // 结束后 index++
            curIndex++;

        }

        return isEven ? sum / 2.0 : sum;

    }
}
