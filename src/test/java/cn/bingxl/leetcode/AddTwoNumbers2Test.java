package cn.bingxl.leetcode;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class AddTwoNumbers2Test {
    int[][][] inputs = { { { 1, 2, 3 }, { 4, 5, 6 } }, { { 1, 5, 7 }, { 9, 1, 2, 3, 5 } } };
    int[][] expects = { { 5, 7, 9 }, { 0, 7, 9, 3, 5 } };
    AddTwoNumbers2 ins = new AddTwoNumbers2();

    @Test
    public void solutionTest() {
        for (int i = 0; i < inputs.length; i++) {
            int[][] input = inputs[i];
            AddTwoNumbers2.ListNode result = ins.addTwoNumbers(
                    AddTwoNumbers2.arrayToList(input[0]), AddTwoNumbers2.arrayToList(input[1]));
            assertArrayEquals("x", expects[i], AddTwoNumbers2.listToArray(result));
        }
    }

}
