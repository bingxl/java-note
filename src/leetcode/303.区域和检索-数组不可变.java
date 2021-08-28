/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
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

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(left,right);
 */
// @lc code=end
