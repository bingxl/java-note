package cn.bingxl.example;

import java.util.Calendar;

/**
 * @author bingxl <bingxl@outlook.com>
 */
public class CalendarExample {
    public static void main(String[] args) {
        Calendar cl = Calendar.getInstance();
        cl.set(2021, 7, 31, 0, 0, 0);
        Util.print(cl.getTime());

        // add方法，当下一级溢出时执行最小改变策略
        cl.add(Calendar.MONTH, 1);
        Util.print(cl.getTime());

        // set方法，下一级溢出时会修正到正确的日期
        cl.set(2021, 7, 31);
        cl.set(Calendar.MONTH, 8);
        Util.print(cl.getTime());
    }
}
