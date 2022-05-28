package cn.bingxl.leetcode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MedianOfTwoSortedArrays4Test {
    private int[][][] inputs = { { { 1, 2 }, { 3, 4 } }, { { 1, 3 }, { 2, 4 } }, { { 1, 3 }, { 5, 7, 9 } } };
    private double[] expects = { 5 / 2.0, 5 / 2.0, 5.0 };

    private MedianOfTwoSortedArrays4 ins = new MedianOfTwoSortedArrays4();

    @Test
    public void mergeAndSortTest() {
        for (int i = 0; i < inputs.length; i++) {
            int[][] input = inputs[i];
            double result = ins.mergeAndSort(input[0], input[1]);
            assertTrue("expect: " + expects[i] + " but get: " + result, result == expects[i]);

        }
    }
}
