package cn.bingxl.leetcode;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

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

    /**
     * 构造测试用例，调用传入的方法处理
     * 
     * @param fun 调用的方法
     * @return Iterator<int[]>, int[0] exception value, int[1] the call method
     *         return's value
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    public Iterator<int[]> gen(String fun)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        ArrayList<int[]> items = new ArrayList<int[]>();

        for (int groupId = 0; groupId < searchs.length; groupId++) {

            int[] expect = expects[groupId];
            int[][] searchLocations = searchs[groupId];
            RangeSumQueryImmutable303 tclass = new RangeSumQueryImmutable303(nums[groupId]);
            Method method = tclass.getClass().getMethod(fun, Integer.TYPE, Integer.TYPE);

            for (int searchId = 0; searchId < searchLocations.length; searchId++) {
                int left = searchLocations[searchId][0];
                int right = searchLocations[searchId][1];
                Object result = method.invoke(tclass, left, right);
                items.add(new int[] { expect[searchId], (Integer) result });
            }

        }
        return items.iterator();
    }

    @Test
    public void sampleTest() {
        Iterator<int[]> items;
        try {
            items = this.gen("sumRange");

        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        while (items.hasNext()) {
            int[] result = items.next();
            assertEquals(result[0], result[1]);
        }

    }

    @Test
    public void solution2Test() {
        Iterator<int[]> items;
        try {
            items = this.gen("solution2");

        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        while (items.hasNext()) {
            int[] result = items.next();
            assertEquals(result[0], result[1]);
        }
    }
}