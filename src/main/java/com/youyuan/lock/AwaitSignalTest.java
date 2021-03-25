package com.youyuan.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类名称：AwaitSignalTest <br>
 * 类描述： Lock配合Condition的await()和signal()方法实现线程间通信 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/7 10:58<br>
 */
public class AwaitSignalTest {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "\t" + "------com in");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "\t" + "线程被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                lock.lock();
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "唤醒线程");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "B").start();
    }

}
