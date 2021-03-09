package cn.bingxl.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import cn.bingxl.leetcode.P1;
import org.junit.jupiter.api.Test;

public class P1Test {
	private final P1 p1 = new P1();

	@Test
	public void twoSumTest() {
		int[] sums = { 1, 2, 3, 4, 5 };
		int target = 9;
		assertArrayEquals(p1.twoSum(sums, target), new int[] { 3, 4 });
	}
}
