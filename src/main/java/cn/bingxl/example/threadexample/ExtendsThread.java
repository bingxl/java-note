package cn.bingxl.example.threadexample;

import cn.bingxl.example.Util;

/**
 * 继承Thread 类实现多线程
 * 
 * @author bingxl
 */
public class ExtendsThread extends Thread {
    private int i = 0;

    public static void main(String[] args) {
        for (var i = 0; i < 10; i++) {
            Util.log.info(String.format("当前线程: %s, 编号: %d", Thread.currentThread(), i));
            if (i == 5) {
                // 调用start启动线程
                new ExtendsThread().start();
            }
        }
    }

    /**
     * 线程执行体
     */
    public void run() {
        for (; i < 10; i++) {
            // getName获取线程的名字
            Util.log.info(this.getName() + " " + i);
        }
    }
}
