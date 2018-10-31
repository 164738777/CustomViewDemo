package com.example.javademo;

/**
 * 作者:  lbqiang on 2018/10/30 22:49
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */
public interface Interface2 extends Interface1{
    // 无法继承static方法
    static void staticMethod() {
        System.out.println("Interface2接口中的静态方法，jdk8支持");
    }

    // 可以重写默认方法
    default void defaultMethod() {
        System.out.println("Interface2预先实现的默认方法, 可以选择性实现");
    }
}
