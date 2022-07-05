package cn.bingxl.leetcode;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class LongestPalindromicSubstring5Test {
    LongestPalindromicSubstring5 in = new LongestPalindromicSubstring5();
    String[][] cases = { { "aba", "aba" }, { "aaaaa", "aaaaa" }, { "abcde", "a" }, { "cbbd", "bb" } };

    @Test
    public void solution1Test() {
        for (var ca : cases) {
            var get = in.longestPalindrome(ca[0]);
            assertTrue(ca[1].equals(get));
        }

    }

    @Test
    public void dynamicPlanningTest() {
        for (var ca : cases) {
            var get = in.dynamicPlanning(ca[0]);
            assertEquals(String.format("except: %s, but get: %s", ca[1], get), ca[1], (get));
        }
    }
}
