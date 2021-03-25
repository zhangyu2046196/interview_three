package com.youyuan;

import com.youyuan.aop.CalcService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 类名称：AopTest <br>
 * 类描述： 测试类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/7 21:36<br>
 */
@SpringBootTest
public class AopTest {

    @Resource
    private CalcService calcService;

    @Test
    public void testAop4(){
        System.out.println("Spring版本"+ SpringVersion.getVersion()+" SpringBoot版本"+ SpringBootVersion.getVersion());
        System.out.println();

        calcService.execute(10,2);

//        calcService.execute(10,0);
    }

    @Test
    public void testAop5(){
        System.out.println("Spring版本"+ SpringVersion.getVersion()+" SpringBoot版本"+ SpringBootVersion.getVersion());
        System.out.println();

//        calcService.execute(10,2);

        calcService.execute(10,0);
    }

}
