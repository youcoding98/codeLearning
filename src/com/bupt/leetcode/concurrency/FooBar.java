package com.bupt.leetcode.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Leetcode1115:交替打印FooBar
 * @author ge
 */
public class FooBar {
    private int n;
    private boolean flag = true;
    CyclicBarrier cb = new CyclicBarrier(2);


    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n;i++) {
            while (!flag){

            }
            printFoo.run();
            flag = false;
            try {
                cb.await();
            }catch (BrokenBarrierException e){

            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n;i++) {
            try {
                cb.await();
            }catch (BrokenBarrierException e){

            }
            printBar.run();
            flag = true;
        }
    }
}
