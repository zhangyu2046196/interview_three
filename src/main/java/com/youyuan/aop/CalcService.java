package com.youyuan.aop;

/**
 * 类名称：CalcService <br>
 * 类描述： 计算接口：用于演示spring中五个通知的执行顺序 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/7 21:14<br>
 */
public interface CalcService {

    int execute(int x, int y);
}
