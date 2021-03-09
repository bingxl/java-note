/**
 * @author bingxl<scarecrowlxb@qq.com>
 */

package cn.bingxl.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P1 {
	/**
	 * 求两数之和的暴力破解法
	 * 
	 * @param nums   数组
	 * @param target 目标
	 * @return 查找到的两数索引
	 */
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("数组中没有两个和为给定值");
	}

	/**
	 * Hash查找法
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>(nums.length);

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}

		throw new IllegalArgumentException("数组中没有两个和为给定值");
	}
}