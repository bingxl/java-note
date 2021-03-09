package cn.bingxl.leetcode;

/**
 * 求数组中指定两个位置及之间的元素之和
 * 
 * @author bingxl <bingxl@outlook.com>
 */
public class P303 {
	private int[] nums;

	public P303(int[] nums) {
		this.nums = nums;
	}

	public int sumRange(int i, int j) {
		if (i >= this.nums.length) {
			return 0;
		}
		j = j > this.nums.length ? this.nums.length : j;
		int sum = 0;
		for (int k = i; k <= j; k++) {
			sum += this.nums[k];
		}
		return sum;
	}
}