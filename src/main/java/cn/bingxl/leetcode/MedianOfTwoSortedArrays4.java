package cn.bingxl.leetcode;

/**
 * [4] 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 
 * @author bingxl<bingxl@outlook.com>
 * 
 */
public class MedianOfTwoSortedArrays4 {
    double solution1(int[] nums1, int[] nums2) {
        double result = 0.0;
        int countNum = nums1.length + nums2.length;
        // 中位数下标
        int halfPos = countNum / 2;
        boolean hasNext = countNum % 2 == 0;
        if (hasNext) {
            // countNum为偶数时halfPos指向中位数的第一个。
            halfPos--;
        }

        int curPos = 0;

        int p2 = 0;
        for (int p1 = 0; p1 < nums1.length; p1++) {
            while (nums1[p1] > nums2[p2]) {
                p2++;

            }
        }

        return result;
    }
}
