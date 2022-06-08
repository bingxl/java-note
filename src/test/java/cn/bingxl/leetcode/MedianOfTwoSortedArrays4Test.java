package cn.bingxl.leetcode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MedianOfTwoSortedArrays4Test {
    private int[][][] inputs = { { { 1, 2 }, { 3, 4 } }, { { 1, 3 }, { 2, 4 } }, { { 1, 3 }, { 5, 7, 9 } } };
    private double[] expects = { 5 / 2.0, 5 / 2.0, 5.0 };

    private MedianOfTwoSortedArrays4 ins = new MedianOfTwoSortedArrays4();

    @Test
    public void mergeAndSortTest() {
        for (var i = 0; i < inputs.length; i++) {
            var input = inputs[i];
            var result = ins.mergeAndSort(input[0], input[1]);
            assertTrue("expect: " + expects[i] + " but get: " + result, result == expects[i]);

        }
    }

    @Test
    public void linkSortedTest() {
        for (var i = 0; i < inputs.length; i++) {
            var input = inputs[i];
            var result = ins.linkSorted(input[0], input[1]);
            assertTrue("expect: " + expects[i] + " but get: " + result, result == expects[i]);

        }
    }
}
