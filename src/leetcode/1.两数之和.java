/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (51.89%)
 * Likes:    11921
 * Dislikes: 0
 * Total Accepted:    2.4M
 * Total Submissions: 4.6M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 
 * 你可以按任意顺序返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 
 * -10^9 
 * -10^9 
 * 只会存在一个有效答案
 * 
 * 
 * 进阶：你可以想出一个时间复杂度小于 O(n^2) 的算法吗？
 * 
 */

// @lc code=start
import java.util.HashMap;

/**
 * 给定条件中 nums[i] 和 target 都在 [-10^9,10^9]之间，用 integer能完整存储。
 * 
 */
class Solution {
    public static void main(String[] args) {
        Solution ins = new Solution();
        System.out.print(ins.twoSum(new int[] { 1, 2, 3, 4, 5 }, 9));
    }

    public int[] twoSum(int[] nums, int target) {
        return solution2(nums, target);
    }

    /**
     * description 暴力破解 T O(n^2) S O(1)
     */
    int[] solution1(int[] nums, int target) {
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

    int[] solution2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
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
// @lc code=end
