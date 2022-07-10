package cn.bingxl.example.threadexample;

/**
 * @author bingxl
 */
public class ThreadWithRunnable implements Runnable {
    /**
     * 线程执行体
     */
    public void run() {
        //
    }

    public static void main(String args) {
        ThreadWithRunnable rt = new ThreadWithRunnable();
        new Thread(rt).start();
        new Thread(rt, "线程名").start();
    }
}
