package com.youyuan.aop;

import org.springframework.stereotype.Service;

/**
 * 类名称：CalcServiceImpl <br>
 * 类描述： 计算接口实现类：用于演示spring通知的执行顺序 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/7 21:15<br>
 */
@Service
public class CalcServiceImpl implements CalcService {
    @Override
    public int execute(int x, int y) {
        int result = x / y;
        System.out.println("========CalcServiceImpl的接口被执行" + result);
        return result;
    }
}
