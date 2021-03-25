package com.youyuan.circulardependency.setter;

/**
 * 类名称：ClientTest <br>
 * 类描述： setter方法注入可以解决循环依赖问题 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/9 21:58<br>
 */
public class ClientTest {

    public static void main(String[] args) {
        ServiceAA serviceAA = new ServiceAA();
        ServiceBB serviceBB = new ServiceBB();

        serviceAA.setServiceBB(serviceBB);
        serviceBB.setServiceAA(serviceAA);
    }

}
