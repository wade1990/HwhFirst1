package com.hwh.Consumer;

/**
 * Created by huangwanhong on 2017/3/26.
 */

public class Test1 {
    private static Integer count = 0;
    private final Integer FULL = 5;
    private static final String lock = "lock";

    public static void main(String[] args) {
        Test1 t = new Test1();
        new Thread(t.new Producer()).start();
        new Thread(t.new Consumer()).start();
/*        new Thread(t.new Producer()).start();
        new Thread(t.new Consumer()).start();*/
    }

    private class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                synchronized (lock) {
                    while (count == FULL) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "produce:: " + count);
                    lock.notifyAll();
                }
            }
        }
    }

    private class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                synchronized (lock) {
                    while (count == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "consume:: " + count);
                    lock.notifyAll();
                }
            }
        }
    }
}
