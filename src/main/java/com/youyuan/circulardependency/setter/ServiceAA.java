package com.youyuan.circulardependency.setter;

/**
 * 类名称：ServiceAA <br>
 * 类描述： 测试setter方法注入循环依赖问题 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/9 21:55<br>
 */
public class ServiceAA {

    private ServiceBB serviceBB;

    public ServiceBB getServiceBB() {
        return serviceBB;
    }

    public void setServiceBB(ServiceBB serviceBB) {
        this.serviceBB = serviceBB;
        System.out.println("ServiceAA类中通过setter方式注入了ServiceBB");
    }
}
