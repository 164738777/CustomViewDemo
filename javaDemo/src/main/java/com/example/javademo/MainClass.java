package com.example.javademo;

/**
 * 说明:
 * 1. 接口之间继承，静态方法不会继承，无法重写(修饰符已经默认public)
 * 2. 接口之间继承，默认方法会继承并可以重写.
 * 3. 类之间继承，方法继承要看修饰符，静态方法无法重写
 */
public class MainClass {
    public static void main(String... args) {
        System.out.println("Hello World");

        Interface1.staticMethod();
        Interface2.staticMethod();

        new Class1().defaultMethod();
        Class1.staticMethod1();
        Class2.staticMethod1();


        InnerClass.Haha haha = new InnerClass().new Haha();
        haha.print();
        haha.print2();
        haha.print3("~~~~~~~~");
    }
}
