package com.youyuan.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * 类名称：ParkUnParkTest <br>
 * 类描述： 线程阻塞和唤醒方式之LockSupport的park()和unPark()方式 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/7 11:45<br>
 */
public class ParkUnParkTest {

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "------com in");
            LockSupport.park();//阻塞线程
            System.out.println(Thread.currentThread().getName() + "\t" + "线程被唤醒");
        }, "A");
        a.start();

        Thread b = new Thread(() -> {
            LockSupport.unpark(a);//唤醒线程
            System.out.println(Thread.currentThread().getName() + "\t" + "唤醒线程");
        }, "B");
        b.start();
    }

}
