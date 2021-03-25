package com.youyuan.circulardependency.setter;

/**
 * 类名称：ServiceBB <br>
 * 类描述： 测试setter方法循环依赖问题 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/9 21:56<br>
 */
public class ServiceBB {

    private ServiceAA serviceAA;

    public ServiceAA getServiceAA() {
        return serviceAA;
    }

    public void setServiceAA(ServiceAA serviceAA) {
        this.serviceAA = serviceAA;
        System.out.println("ServiceBB类中通过setter方式注入了ServiceAA");
    }
}
