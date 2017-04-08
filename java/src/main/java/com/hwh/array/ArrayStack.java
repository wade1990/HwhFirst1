package com.hwh.array;

/**
 *
 *
 * 栈只允许访问一个数据项：即最后插入的数据。溢出这个数据才能访问倒数第二个插入的数据项。它是一种"后进先出"的数据结构。
 * 栈最基本的操作是出栈(Pop)、入栈(Push)，还有其他扩展操作，如查看栈顶元素，判断栈是否为空、是否已满，读取栈的大小等。
 */
/**
 * 栈是先进后出
 * 只能访问栈顶的数据
 * @author dream
 *
 */

/**
 * 基于数组来实现栈的基本操作
 * 数据项入栈和出栈的时间复杂度均为O(1)
 * @author dream
 *
 */
public class ArrayStack {

    private long[] a;
    private int size;   //栈数组的大小
    private int top;   //栈顶

    public ArrayStack(int maxSize){
        this.size = maxSize;
        this.a = new long[size];
        this.top = -1;   //表示空栈
    }

    public void push(long value){   //入栈
        if(isFull()){
            System.out.println("栈已满!");
            return;
        }
        a[++top] = value;
    }

    public long peek(){   //返回栈顶内容，但不删除
        if(isEmpty()){
            System.out.println("栈中没有数据");
            return 0;
        }
        return a[top];
    }


    public long pop(){   //弹出栈顶内容
        if(isEmpty()){
            System.out.println("栈中没有数据!");
            return 0;
        }
        return a[top--];
    }

    public int size(){
        return top + 1;
    }

    /**
     * 判断是否满了
     * @return
     */
    public boolean isFull(){
        return (top == size - 1);
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return (top == -1);
    }


    public void display(){
        for (int i = top; i >= 0; i--) {
            System.out.println(a[i] + " ");
        }
        System.out.println("");
    }




    /**
     * 插入
     *
     * @param old
     * @param value
     * @param index
     * @return
     */
    public static int[] insert(int[] old, int value, int index) {
        for (int k = old.length - 1; k > index; k--)
            old[k] = old[k - 1];
        old[index] = value;
        return old;
    }

    /**
     * 遍历
     *
     * @param data
     */
    public static void traverse(int data[]) {
        for (int j = 0; j < data.length; j++) {
            System.out.println(data[j] + " ");
        }
    }

    /**
     * 删除
     *
     * @param old
     * @param index
     * @return
     */
    public static int[] delete(int[] old, int index) {
        for (int h = index; h < old.length - 1; h++) {
            old[h] = old[h + 1];
        }
        old[old.length - 1] = 0;
        return old;
    }


}
