package com.example.javademo;

/**
 * 作者:  lbqiang on 2018/10/28 22:50
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */
public interface Interface1 {
    int CONTANT = 1;
    //    public static final int CONTANT = 1;

    void method();
    //    public void method();

    default void defaultMethod() {
        System.out.println("Interface1预先实现的默认方法, 可以选择性实现");
    }

    static void staticMethod() {
        System.out.println("接口中的静态方法，jdk8支持");
    }
}
