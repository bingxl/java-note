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
    private int[] sums;

    public RangeSumQueryImmutable303(int[] nums) {
        this.nums = nums;

        // 提前计算好sum[n];
        this.sums = new int[nums.length];

        this.sums[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            this.sums[i] = this.sums[i - 1] + nums[i];
        }
    }

    /**
     * 最简单的方法， 但题目中描述会有很多次调用，时间复杂度 O(n), 相对耗时
     * 
     * @param left
     * @param right
     * @return 从left到right的和
     */

    public int sumRange(int left, int right) {
        // 处理边界问题
        if (left >= this.nums.length) {
            return 0;
        }
        // 左边界超出从0开始
        left = left < 0 ? 0 : left;
        // 右边界超出则取数组长度
        right = right > this.nums.length ? this.nums.length : right;

        int sum = 0;
        // 不需要单独处理left>right的情况，这种情况下sum为0
        for (int k = left; k <= right; k++) {
            sum += this.nums[k];
        }
        return sum;
    }

    /**
     * 时间复杂度 O(1)
     * 空间复杂度 O(n); 此方法需要在构造函数里提前计算sums[n]
     * 
     * @param left
     * @param right
     * @return
     */
    public int solution2(int left, int right) {
        // 处理边界问题
        if (left >= this.nums.length) {
            return 0;
        }
        // 左边界超出从0开始
        left = left < 0 ? 0 : left;
        // 右边界超出则取数组长度
        right = right > this.nums.length ? this.nums.length : right;

        if (left == 0) {
            return this.sums[right];
        }

        return this.sums[right] - this.sums[left - 1];
    }
}
