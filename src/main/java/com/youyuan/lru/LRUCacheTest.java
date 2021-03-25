package com.youyuan.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 类名称：LRUCacheTest <br>
 * 类描述： 通过LinkedHashMap实现LRU算法 <br>
 *
 *  LRU算法主要针对key的频率判断依据信息
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/24 22:27<br>
 */
public class LRUCacheTest<K,V> extends LinkedHashMap {

    /**
     * 初始容量
     */
    private static final Integer capcity=3;
    /**
     * 负载因子
     */
    private static final Float loadFactor=0.75f;
    /**
     * 排序：
     *   true:访问顺序排序
     *   false:插入顺序排序
     */
    private static final Boolean accessOrder=Boolean.TRUE;

    public LRUCacheTest(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size()>capcity;
    }

    public static void main(String[] args) {
        LRUCacheTest<Object, Object> lruCacheTest = new LRUCacheTest<>(capcity, loadFactor, Boolean.FALSE);
        lruCacheTest.put(1,"a");
        System.out.println("第一次:"+lruCacheTest.keySet());
        lruCacheTest.put(2,"b");
        System.out.println("第二次:"+lruCacheTest.keySet());
        lruCacheTest.put(3,"c");
        System.out.println("第三次:"+lruCacheTest.keySet());
        lruCacheTest.put(4,"d");
        System.out.println("第四次:"+lruCacheTest.keySet());
        lruCacheTest.put(3,"c");
        System.out.println("第五次:"+lruCacheTest.keySet());
        lruCacheTest.put(3,"c");
        System.out.println("第六次:"+lruCacheTest.keySet());
        lruCacheTest.put(3,"c");
        System.out.println("第七次:"+lruCacheTest.keySet());
        lruCacheTest.put(5,"e");
        System.out.println("第八次:"+lruCacheTest.keySet());
    }
}

/**
 * 排序：true按照访问顺序执行结果
 * 第一次:[1]
 第二次:[1, 2]
 第三次:[1, 2, 3]
 第四次:[2, 3, 4]
 第五次:[2, 4, 3]
 第六次:[2, 4, 3]
 第七次:[2, 4, 3]
 第八次:[4, 3, 5]
 */

/**
 * 排序：false按照插入顺序执行结果
 * 第一次:[1]
 第二次:[1, 2]
 第三次:[1, 2, 3]
 第四次:[2, 3, 4]
 第五次:[2, 3, 4]
 第六次:[2, 3, 4]
 第七次:[2, 3, 4]
 第八次:[3, 4, 5]
 */
