/**
 * @author bingxl<bingxl@outlook.com>
 */

package cn.bingxl.example;

import java.util.Arrays;

public class Hello {

    public static void main(String[] args) {
        System.out.println("测试内容");
        System.out.println(Float.NaN);
        System.out.println(Float.POSITIVE_INFINITY);
        System.out.println(Float.NEGATIVE_INFINITY);

        int count = 0;
        int end = 10;
        while (count < end) {
            System.out.println(count++);
        }

        int[][] nums = { { 1, 2, 3, 4 }, { 2, 3, 4, 5 } };
        System.out.println(Arrays.toString(nums));

    }

}