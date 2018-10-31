package com.example.javademo;

/**
 * 作用:
 * 1. 接口之间继承，静态方法不会继承，无法重写(修饰符已经默认public)
 * 2. 类之间继承，方法继承要看修饰符，静态方法无法重写
 */
public class MainClass {
    public static void main(String... args) {
        System.out.println("Hello World");

        Interface1.staticMethod();
        Interface2.staticMethod();

        new Class1().defaultMethod();
        new Class1().staticMethod1();
        new Class2().staticMethod1();
    }
}
