package com.youyuan.stringpool;

/**
 * 类名称：StringPollTest <br>
 * 类描述： 字符串常量java内部加载之intern方法 <br>
 * <p>
 * 调用intern方法时先从字符串常量池中去取，如果存在方法对象引用，如果不存在创建字符串放入字符串常量值然后在返回
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/4 22:59<br>
 */
public class StringPollTest {

    public static void main(String[] args) {
        String str1 = new StringBuilder("re").append("dis").toString();
        System.out.println("str1:" + str1);
        System.out.println("str1.intern:" + str1.intern());
        System.out.println(str1 == str1.intern());

        System.out.println();

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println("str2:" + str2);
        System.out.println("str2.intern:" + str2.intern());
        System.out.println(str2 == str2.intern());
    }

}
