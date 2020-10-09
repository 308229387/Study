package com.learn.java;

/*
 * 饿汉模式，很饿很着急，所以类加载时即创建实例对象。java.lang.Runtime
 * https://blog.csdn.net/yin767833376/article/details/54379345  这个写的比较细
 * */
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return singleton;
    }
}

/*
 * 饱汉模式，很饱不着急，延迟加载，啥时候用啥时候创建实例，存在线程安全问题，要用synchronized标识
 * */
class Singleton2 {
    private static Singleton2 singleton2;

    private Singleton2() {}

    public static synchronized Singleton2 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}

/*
 * 饱汉模式的双重锁模式，提高效率
 * */
class Singleton3 {
    private static Singleton3 singleton3;

    private Singleton3() {}

    public static Singleton3 getInstance() {
        if (singleton3 == null) {
            synchronized (Singleton3.class) {
                if (singleton3 == null) {
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
