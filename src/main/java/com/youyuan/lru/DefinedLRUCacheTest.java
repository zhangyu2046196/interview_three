package com.youyuan.lru;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名称：DefinedLRUCacheTest <br>
 * 类描述： 自定义LRU算法 <br>
 * <p>
 * 构建一个双向链表,链表里面存储Node节点,Node作为数据载体
 * <p>
 * 双向链表的头节点和尾结点都是哨兵节点
 * <p>
 * //1、构建Node节点
 * //2、构建双向链表
 * //3、Map负责查找
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/24 23:03<br>
 */
public class DefinedLRUCacheTest {
    /**
     * 容量
     */
    private Integer capcity = 3;
    /**
     * map负责查找
     */
    private Map<Integer, Node<Integer, String>> map;
    /**
     * 双向链表信息
     */
    private DoubleLinkedList<Integer, String> doubleLinkedList;

    public DefinedLRUCacheTest() {
        this.map=new HashMap<>();
        this.doubleLinkedList=new DoubleLinkedList<>();
    }

    public DefinedLRUCacheTest(Map<Integer, Node<Integer, String>> map, DoubleLinkedList<Integer, String>
            doubleLinkedList) {
        this.map = map;
        this.doubleLinkedList = doubleLinkedList;
    }

    /**
     * 方法名: get <br>
     * 方法描述: 查询 <br>
     * <p>
     * 每查询一次,节点重新插入做到了排序
     *
     * @param key key
     * @return {@link String 返回查询value信息 }
     * @date 创建时间: 2021/3/24 23:52 <br>
     * @author zhangyu
     */
    public String get(Integer key) {
        //不存在
        if (!map.containsKey(key)) {
            return "不存在  ";
        }
        Node<Integer, String> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    public void put(Integer key, String value) {
        if (map.containsKey(key)) {
            //key存在更新value
            Node<Integer, String> node = map.get(key);
            //链表删除原node
            doubleLinkedList.removeNode(node);
            //value赋值
            node.value = value;
            //链表重新添加node
            doubleLinkedList.addHead(node);
        } else {
            if (map.size() == capcity) {
                //没有坑位了,删除最后一个在添加新的
                Node lastNode = doubleLinkedList.getLastNode();
                doubleLinkedList.removeNode(lastNode);
                //map删除
                map.remove(lastNode.key);
            }
            Node newNode = new Node(key, value);
            doubleLinkedList.addHead(newNode);
            map.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        DefinedLRUCacheTest lruCacheTest = new DefinedLRUCacheTest();
        lruCacheTest.put(1,"a");
        System.out.println("第一次:"+lruCacheTest.map.keySet());
        lruCacheTest.put(2,"b");
        System.out.println("第二次:"+lruCacheTest.map.keySet());
        lruCacheTest.put(3,"c");
        System.out.println("第三次:"+lruCacheTest.map.keySet());
        lruCacheTest.put(4,"d");
        System.out.println("第四次:"+lruCacheTest.map.keySet());
        lruCacheTest.put(3,"c");
        System.out.println("第五次:"+lruCacheTest.map.keySet());
        lruCacheTest.put(3,"c");
        System.out.println("第六次:"+lruCacheTest.map.keySet());
        lruCacheTest.put(3,"c");
        System.out.println("第七次:"+lruCacheTest.map.keySet());
        lruCacheTest.put(5,"e");
        System.out.println("第八次:"+lruCacheTest.map.keySet());
    }

}

/**
 * 类名称：Node <br>
 * 类描述： node节点作为数据载体,包涵前一个节点和后一个节点 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/24 23:08<br>
 */
class Node<K, V> {
    /**
     * key
     */
    K key;
    /**
     * value
     */
    V value;
    /**
     * 前一个节点
     */
    Node<K, V> prev;
    /**
     * 下一个节点
     */
    Node<K, V> next;

    public Node() {
        this.prev = this.next = null;
    }

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.prev = this.next = null;
    }
}

/**
 * 类名称： <br>
 * 类描述： TODO <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/24 23:10<br>
 */
class DoubleLinkedList<K, V> {
    /**
     * 头节点
     */
    Node<K, V> head;
    /**
     * 尾结点
     */
    Node<K, V> tail;

    public DoubleLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.prev = head;
    }

    /**
     * 方法名: addHead <br>
     * 方法描述: 从头部添加节点 <br>
     *
     * @param node 要添加的节点
     * @date 创建时间: 2021/3/24 23:25 <br>
     * @author zhangyu
     */
    public void addHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 方法名: removeNode <br>
     * 方法描述: 删除一个节点 <br>
     *
     * @param node 删除的节点信息
     * @date 创建时间: 2021/3/24 23:34 <br>
     * @author zhangyu
     */
    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    /**
     * 方法名: getLastNode <br>
     * 方法描述: 查询最后一个节点 <br>
     * <p>
     * 双向链表中的头节点和尾结点是哨兵节点
     *
     * @return {@link Node 返回查询的节点 }
     * @date 创建时间: 2021/3/24 23:35 <br>
     * @author zhangyu
     */
    public Node getLastNode() {
        return tail.prev;
    }
}
