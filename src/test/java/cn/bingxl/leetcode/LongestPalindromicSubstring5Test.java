package cn.bingxl.leetcode;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LongestPalindromicSubstring5Test {
    LongestPalindromicSubstring5 in = new LongestPalindromicSubstring5();

    @Test
    public void solution1Test() {
        var input = "ababababa";
        var expect = "ababababa";
        var get = in.longestPalindrome(input);
        assertTrue(expect.equals(get));
    }
}
