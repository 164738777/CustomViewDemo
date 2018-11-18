package com.example.javademo;

/**
 * 作者:  lbqiang on 2018/11/17 11:38
 * 邮箱:  anworkmail_q@126.com
 * 作用:  泛型类
 */
public class GenericClass<T> {
    private T mT;

    public T get() {
        return mT;
    }

    public void set(T t) {
        this.mT = t;
    }

    // 泛型方法也可以再普通类里面用
    public static <T> T getArrayMiddleOne(T... a) {
        return a[a.length / 2];
    }

    // 限定符的泛型方法
    // 多个限定符
    // public static <T extends Comparable & Serializable> T min(T... a){
    public static <T extends Comparable> T min(T... a){
        if (a == null || a.length == 0) {
            return null;
        }

        T min = a[0];

        for (T anA : a) {
            if (min.compareTo(anA) > 0) {
                min = anA;
            }
        }
        return min;
    }

    // 通配符 ？
    public void test1(GenericClass<? extends Class2> a) {
    }
    // 通配符?超限定, 限制为Class2的超类
    public void test2(GenericClass<? super Class2> a) {
    }
    // 通配符?无限定
    public void test3(GenericClass<?> a) {
    }


    public static void main(String[] args) {
        // 泛型方法的调用
        String arrayMiddleOne = GenericClass.<String>getArrayMiddleOne("Hello", "H", "E");
        System.out.println(arrayMiddleOne);

        Integer min = GenericClass.min(5, 0, 6);
        System.out.println(min);
    }
}
