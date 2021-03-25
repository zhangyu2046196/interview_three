package com.youyuan.circulardependency.constractor;

/**
 * 类名称：ServiceB <br>
 * 类描述： 测试构造器注入循环依赖问题 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/9 21:46<br>
 */
public class ServiceB {

    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
