package com.hwh;

import com.hwh.array.ArrayStack;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyJavaMainClass {
    public static void main(String[] args){
/*
        RoundQueue roundQueue = new RoundQueue(5);
        roundQueue.insert(1);
        roundQueue.insert(2);
        roundQueue.insert(3);
        roundQueue.insert(4);
        roundQueue.insert(6);
        roundQueue.insert(7);
        System.out.println("main: " + roundQueue.peek());
        System.out.println("main: " + roundQueue.remove());
        System.out.println("main: " + roundQueue.peek());

        System.out.println("===================================");

        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.insert(5);
        priorityQueue.insert(7);
        priorityQueue.insert(3);
        priorityQueue.insert(8);
        priorityQueue.insert(1);

        priorityQueue.display();
*/

/*        String names[];
        names = new String[5];
        names[0] = "egg";
        names[1] = "erqing";
        names[2] = "baby";
        for (String aName : names) {
            System.out.println(aName);
        }*/

        Lock l = new ReentrantLock();
        l.lock();
        String b = String.valueOf(1);
        l.unlock();

        int[] a = new int[]{1, 2, 3, 4};
        int[] insert = ArrayStack.insert(a, 100, 1);
        for (int i : insert) {
            System.out.println("" + i);
        }

        int[] delete = ArrayStack.delete(insert, 1);
        for (int i : delete) {
            System.out.println("2222   " + i);
        }
    }

}
