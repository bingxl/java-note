package cn.bingxl.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseInteger7Test {
    private ReverseInteger7 ins = new ReverseInteger7();
    private int[][] cases = {
            { 123, 321 },
            { -12, -21 },
            { 8231230, 321328 },
            { Integer.MAX_VALUE + 1, 0 },
            { Integer.MIN_VALUE - 1, 0 },
            { 2147483640, 463847412 },
            { 1147483648, 0 },
            { -2147483412, -2143847412 }
    };

    @Test
    public void reverseTest() {
        for (int[] cs : cases) {
            var result = ins.reverse(cs[0]);

            assertEquals(cs[1], result);
        }
    }
}
