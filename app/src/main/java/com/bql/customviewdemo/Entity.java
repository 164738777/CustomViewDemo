package com.bql.customviewdemo;

import android.support.v7.app.AppCompatActivity;

/**
 * 作者:  lbqiang on 2018/8/7 23:27
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */
public class Entity {
    private String name;
    private Class<? extends AppCompatActivity> targetClass;

    public Entity() {
        this("", null);
    }

    public Entity(String name) {
        this(name, null);
    }

    public Entity(String name, Class<? extends AppCompatActivity> targetClass) {
        this.name = name;
        this.targetClass = targetClass;
    }

    public String getName() {
        return name;
    }

    public Class<? extends AppCompatActivity> getTargetClass() {
        return targetClass;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", targetClass=" + targetClass +
                '}';
    }
}
