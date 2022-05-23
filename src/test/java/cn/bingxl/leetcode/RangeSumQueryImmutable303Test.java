package cn.bingxl.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RangeSumQueryImmutable303Test {
    int[][] nums = {
            { 1, 2, 3, 4, 5, 6 },
            { 4, 3, 2, 7, 20, 40 }
    };
    int[][][] searchs = {
            { { 0, 3 }, { 1, 5 } },
            { { 0, 4 } }
    };
    int[][] expects = {
            { 10, 20 },
            { 36 }
    };

    @Test
    public void sampleTest() {
        for (int groupId = 0; groupId < searchs.length; groupId++) {

            int[] expect = expects[groupId];
            int[][] searchLocations = searchs[groupId];
            RangeSumQueryImmutable303 tclass = new RangeSumQueryImmutable303(nums[groupId]);

            for (int searchId = 0; searchId < searchLocations.length; searchId++) {
                int left = searchLocations[searchId][0];
                int right = searchLocations[searchId][1];
                int result = tclass.sumRange(left, right);
                System.out.println("left:" + left + " right:" + right + " result:" + result);
                assertEquals(expect[searchId], result);
            }

        }
    }

    @Test
    public void solution2Test() {
        for (int groupId = 0; groupId < searchs.length; groupId++) {

            int[] expect = expects[groupId];
            int[][] searchLocations = searchs[groupId];
            RangeSumQueryImmutable303 tclass = new RangeSumQueryImmutable303(nums[groupId]);

            for (int searchId = 0; searchId < searchLocations.length; searchId++) {
                int left = searchLocations[searchId][0];
                int right = searchLocations[searchId][1];
                int result = tclass.solution2(left, right);
                System.out.println("left:" + left + " right:" + right + " result:" + result);
                assertEquals(expect[searchId], result);
            }

        }
    }
}