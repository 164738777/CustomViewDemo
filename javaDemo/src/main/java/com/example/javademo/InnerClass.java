package com.example.javademo;

/**
 * Description:
 * Author: lbq
 * CreateTime: 2018/11/5 17:23
 */
public class InnerClass {
    private void print0() {
        System.out.println("InnerClass.print0");
    }

    // 内部类
    class Haha {
        public void print() {
            print0();
            System.out.println("haha" + this.getClass().getName());
        }

        public void print2() {
            // 局部内部类
            class Haha2 {
                public void print3() {
                    System.out.println("Haha2.print3");
                }
            }

            new Haha2().print3();
        }

        // JDK8+ 从局部类访问的局部变量(这里的形参)不需要final, 8以下均要声明final
        public void print3(String target) {
            // 局部内部类
            class Haha2 {
                public void print3() {
                    System.out.println("Haha2.print3 --- " + target);
                }
            }

            new Haha2().print3();
        }
    }
}
