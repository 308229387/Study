package com.learn.java;
public class Singleton{
    private static Singleton singleton=new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return singleton;
    }
}

class Singleton1{
    private static Singleton1 singleton1;
    private Singleton1(){};
    public static synchronized Singleton1 getInstance(){
        if(singleton1==null){
            singleton1=new Singleton1();
        }
        return singleton1;
    }
}

 class Singleton2{
    private static volatile Singleton2 singleton2;
    private Singleton2(){}
    public static Singleton2 getInstance(){
        if(singleton2==null){
            synchronized(Singleton2.class){
                if(singleton2==null){
                    singleton2=new Singleton2();
                }
            }
        }
        return singleton2;
    }
}