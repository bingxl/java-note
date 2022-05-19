package cn.bingxl.leetcode;

/**
 * [303] 区域和检索-数组不可变
 * https://leetcode.cn/problems/range-sum-query-immutable
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 * 
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 * 
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和
 * ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 * 
 * @author bingxl<bingxl@outlook.com>
 */

public class RangeSumQueryImmutable303 {
    private int[] nums;

    public RangeSumQueryImmutable303(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        if (left >= this.nums.length) {
            return 0;
        }
        right = left > this.nums.length ? this.nums.length : right;
        int sum = 0;
        for (int k = left; k <= right; k++) {
            sum += this.nums[k];
        }
        return sum;
    }
}
