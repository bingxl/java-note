package cn.bingxl.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

public class TwoSum1Test {
    int[][] nums = { { 1, 2, 3 }, { 1, 2, 3, 4, 5 }, { 7, 3, 6, 4, 10 } };
    int[] targets = { 4, 9, 17 };
    int[][] expect = { { 0, 2 }, { 3, 4 }, { 0, 4 } };
    TwoSum1 twoSum1;

    @Before
    public void init() {
        twoSum1 = new TwoSum1();
    }

    @Test
    public void solution1Test() {
        for (int i = 0; i < nums.length; i++) {
            int[] result = twoSum1.solution1(nums[i], targets[i]);
            assertArrayEquals("expect " + expect[i] + " but get" + Arrays.toString(result), expect[i], result);
        }
    }

    @Test
    public void solution2Test() {
        for (int i = 0; i < nums.length; i++) {
            int[] result = twoSum1.solution1(nums[i], targets[i]);
            assertArrayEquals("expect " + expect[i] + " but get" + Arrays.toString(result), expect[i], result);
        }
    }
}
