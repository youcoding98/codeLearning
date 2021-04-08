package com.bupt.leetcode.concurrency;

/**
 * 多线程循环打印AB
 * @author ge
 */
public class PrintAB {
    public static void main(String[] args) {
        Foo1 f = new Foo1();
        new Thread(){
            @Override
            public void run() {
                f.first(()->{
                    System.out.print("first");
                });
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                f.second(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("second");
                    }
                });
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                f.third(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("third");
                    }
                });
            }
        }.start();

    }
}


class Foo1 {
    private volatile int flag = 1;
    public Foo1() {

    }

    public void first(Runnable printFirst)  {
        while (flag != 1){

        }
        printFirst.run();
        flag = 2;
    }

    public void second(Runnable printSecond)  {
        while (flag != 2){

        }
        printSecond.run();
        flag = 3;

    }

    public void third(Runnable printThird)  {
        while (flag != 3){

        }
        printThird.run();
    }
}