package com.youyuan.lock;

import java.util.concurrent.TimeUnit;

/**
 * 类名称：WaitNotifyTest <br>
 * 类描述： 线程阻塞和唤醒方式之一Object类的wait()阻塞线程,notify()和notifyAll()唤醒线程 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/7 10:28<br>
 */
public class WaitNotifyTest {

    static Object lockObj = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lockObj) {
                System.out.println(Thread.currentThread().getName() + "\t" + "com in");
                try {
                    lockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "线程被唤醒");
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (lockObj) {
                lockObj.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "通知线程唤醒");
            }
        }, "B").start();
    }

}
