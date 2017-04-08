package com.hwh.array;

/**
 * 还有个优先级队列，优先级队列是比栈和队列更专用的数据结构。优先级队列与上面普通的队列相比，主要区别
 * 在于队列中的元素是有序的，关键字最小（或者最大）的数据项总在队头。数据项插入的时候会按照顺序插入到
 * 合适的位置以确保队列的顺序。优先级队列的内部实现可以用数组或者一种特别的树——堆来实现。这里用数组
 * 实现优先级队列。
 *
 * 优先级队列中，插入操作需要O(N)的时间，而删除操作则需要O(1)的时间。
 */
public class PriorityQueue {

    private long[] a;
    private int size;
    private int nItems;  //元素个数

    public PriorityQueue(int maxSize){
        size = maxSize;
        nItems = 0;
        a = new long[size];
    }

    public void insert(long value){
        if(isFull()){
            System.out.println("队列已满！");
            return;
        }
        int j;
        if(nItems == 0){  //空队列直接添加
            a[nItems++] = value;
        }else {
            //将数组中的数字依照下标按照从大到小排列
            for(j=nItems-1; j>=0; j--){
                if(value > a[j]){
                    a[j+1] = a[j];
                }
                else {
                    break;
                }
            }
            a[j+1] = value;
            nItems++;
        }
    }

    public long remove(){
        if(isFull()){
            System.out.println("队列为空!");
            return 0;
        }
        return a[--nItems];
    }

    public long peekMin(){
        return a[nItems - 1];
    }

    public boolean isFull(){
        return (nItems == size);
    }

    public boolean isEmpty(){
        return (nItems == 0);
    }

    public int size(){
        return nItems;
    }

    public void display(){
        for(int i = nItems - 1;i >= 0; i--){
            System.out.println(a[i] + " ");
        }
        System.out.println(" ");
    }
}
