package cn.bingxl.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters3Test {
    private String[] inputs = { "abcabcbb", "bbbbbb", "abcdefg" };
    private int[] expects = { 3, 1, 7 };
    private LongestSubstringWithoutRepeatingCharacters3 ins = new LongestSubstringWithoutRepeatingCharacters3();

    @Test
    public void solution1Test() {
        for (int i = 0; i < inputs.length; i++) {
            int result = ins.solution1(inputs[i]);
            assertEquals("input: " + inputs[i] + " expect get: " + expects[i] + " but get: " + result, expects[i],
                    result);
        }
    }

    @Test
    public void solution2Test() {
        for (int i = 0; i < inputs.length; i++) {
            int result = ins.solution2(inputs[i]);
            assertEquals("input: " + inputs[i] + " expect get: " + expects[i] + " but get: " + result, expects[i],
                    result);
        }
    }
}
