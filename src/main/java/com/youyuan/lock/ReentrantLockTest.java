package com.youyuan.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类名称：ReentrantLockTest <br>
 * 类描述： ReentrantLock底层使用的是AQS,查看AQS底层加锁/释放锁源码 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/7 17:11<br>
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        Lock lock=new ReentrantLock();

        lock.lock();

        lock.unlock();
    }

}
