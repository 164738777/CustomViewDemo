package com.example.javademo;

import java.util.ArrayList;

/**
 * 作者:  lbqiang on 2018/11/18 17:50
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 *
 * 1. LinkedList链表: 增删操作比较快, 查询慢(随机访问, RandomAccess).
 *    如果元素数量少或者要进行访问, 用ArrayList或者数组.
 */
public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(12);
        list.add(1);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    // ArrayDeque 循环双向队列
    // LinkedList 链表
}
