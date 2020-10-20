package com.learn.java;

/*
 * 饿汉
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 * */
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return singleton;
    }
}

/*
 * 懒汉
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁synchronized 才能保证单例，如果多个线程调用，会影响效率
 * */
class Singleton1{
    private static Singleton1 singleton1;

    private Singleton1() {
    }

    public static synchronized Singleton1 getInstance() {
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}


/*
 * 双重锁
 * 优点：资源利用率高，第一次执行方法是单例对象才会被实例化。
 * 缺点：第一次加载时会稍慢，重排序问题jdk1.5之后，加volatile来约束JVM乱序排行。
 * */
class Singleton2 {
    private static volatile Singleton2 singleton2;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (singleton2 == null) {
            synchronized (Singleton2.class) {
                if (singleton2 == null) {
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }
}


/*
 * 静态内部类
 * 优点：不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。
 * 原理：多线程只会有一个线程去执行这个类的<clinit>()方法，其他线程都需要阻塞等待，直到活动线程执行<clinit>()方法完毕。
 * */
class Singleton3 {
    private static Singleton3 singleton3;

    private Singleton3() {
    }

    private static class Singleton3Instance {
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return Singleton3Instance.INSTANCE;
    }
}


/*
 * 枚举
 * 原理：每个枚举实例都是static final类型的，也就表明只能被实例化一次。在调用构造方法时，我们的单例被实例化。
 * */
enum EnumSingleton {
    INSTANCE;
    private Resource instance;

    EnumSingleton() {
        instance = new Resource();
    }

    public Resource getInstance() {
        return instance;
    }
}

class Resource {
}
