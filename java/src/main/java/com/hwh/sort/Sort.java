package com.hwh.sort;

/**
 * Created by huangwanhong on 2017/3/9.
 */

public class Sort {
    public static void main(String[] args) {
        int[] sortInt = new int[]{9,8,5,4,6};
//        5 8 9 4 6
//        5 8 4 9 6
//        5 8 4 6 9
//        5 4 8 6 9
//        5 4 6 8 9
//        4 5 6 8 9
//        Sort sort = new Sort();
//        sort.bubleSort(sortInt);

//        Sort sort = new Sort();
//        sort.selectSort(sortInt);

        Sort sort = new Sort();
        sort.quickSort(sortInt,0,3);

    }

    /**
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误
     * 就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的
     * 名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     * <p>
     * 算法规则： 由于算法每次都将一个最大的元素往上冒，我们可以将待排序集合(0...n)看成两部分，一部分
     * 为(k..n)的待排序unsorted集合，另一部分为(0...k)的已排序sorted集合，每一次都在unsorted集合从前
     * 往后遍历，选出一个数，如果这个数比其后面的数大，则进行交换。完成一轮之后，就肯定能将这一轮unsorted
     * 集合中最大的数移动到集合的最后，并且将这个数从unsorted中删除，移入sorted中。
     *
     * @param args
     */
    public void bubleSort(int[] args) {
        //第一层循环从数组的最后往前遍历
        for (int i = args.length - 1; i > 0; --i) {
            //这里循环的上界是 i - 1，在这里体现出 “将每一趟排序选出来的最大的数从sorted中移除”
            for (int j = 0; j < i; j++) {
                //保证在相邻的两个数中比较选出最大的并且进行交换(冒泡过程)
                if (args[j] > args[j + 1]) {
                    int temp = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序（Selection sort）是一种简单直观的排序算法。它的工作原理如下。首先在未排序序列中找到最
     * 小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后
     * 放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * <p>
     * 算法规则： 将待排序集合(0...n)看成两部分，在起始状态中，一部分为(k..n)的待排序unsorted集合，另
     * 一部分为(0...k)的已排序sorted集合,在待排序集合中挑选出最小元素并且记录下标i，若该下标不等于k，
     * 那么 unsorted[i] 与 sorted[k]交换 ，一直重复这个过程，直到unsorted集合中元素为空为止。
     *
     * @param args
     */
    public void selectSort(int[] args) {
        int len = args.length;
        for (int i = 0, k = 0; i < len; i++, k = i) {
            // 在这一层循环中找最小
            for (int j = i + 1; j < len; j++) {
                // 如果后面的元素比前面的小，那么就交换下标，每一趟都会选择出来一个最小值的下标
                  if (args[k] > args[j]) k = j;
            }

            if (i != k) {
                int tmp = args[i];
                args[i] = args[k];
                args[k] = tmp;
            }
        }
    }

    /**
     * 快速排序
     * 又称划分交换排序（partition-exchange sort），一种排序算法，最早由东尼·霍尔提出。在平均状况下，
     * 排序n个项目要Ο(n log n)次比较。在最坏状况下则需要Ο(n2)次比较，但这种状况并不常见。事实上，快
     * 速排序通常明显比其他Ο(n log n)算法更快，因为它的内部循环（inner loop）可以在大部分的架构上很
     * 有效率地被实现出来 ----- 来自 wikipedia **
     * 算法规则： 本质来说，快速排序的过程就是不断地将无序元素集递归分割，一直到所有的分区只包含一个元素为止。
     * 由于快速排序是一种分治算法，我们可以用分治思想将快排分为三个步骤：
     * 1.分：设定一个分割值，并根据它将数据分为两部分
     * 2.治：分别在两部分用递归的方式，继续使用快速排序法
     * 3.合：对分割的部分排序直到完成
     *
     * @param args
     * @param start
     * @param end
     */
    public void quickSort(int[] args, int start, int end) {
        //当分治的元素大于1个的时候，才有意义
        if (end - start > 1) {
            int mid = 0;
            mid = dividerAndChange(args, start, end);
            // 对左部分排序
            quickSort(args, start, mid);
            // 对右部分排序
            quickSort(args, mid + 1, end);
        }
    }

    private int dividerAndChange(int[] args, int start, int end) {
        //标准值
        int pivot = args[start];
        while (start < end) {
            // 从右向左寻找，一直找到比参照值还小的数值，进行替换
            // 这里要注意，循环条件必须是 当后面的数 小于 参照值的时候
            // 我们才跳出这一层循环
            while (start < end && args[end] >= pivot)
                end--;

            if (start < end) {
                swap(args, start, end);
                start++;
            }

            // 从左向右寻找，一直找到比参照值还大的数组，进行替换
            while (start < end && args[start] < pivot)
                start++;

            if (start < end) {
                swap(args, end, start);
                end--;
            }
        }

        args[start] = pivot;
        return start;
    }

    private void swap(int[] args, int fromIndex, int toIndex) {
        args[fromIndex] = args[toIndex];
    }


    /**
     * 背景介绍： 归并排序是创建在归并操作上的一种有效的排序算法，效率为O(n log n)。1945年由约翰·冯·诺伊曼
     * 首次提出。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用，且各层分治递归可以同时
     * 进行。 ----- 来自 wikipedia
     * 算法规则： 像快速排序一样，由于归并排序也是分治算法，因此可使用分治思想：
     * 1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     * 2.设定两个指针，最初位置分别为两个已经排序序列的起始位置
     * 3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     * 4.重复步骤3直到某一指针到达序列尾
     * 5.将另一序列剩下的所有元素直接复制到合并序列尾
     * @param ints
     * @param merge
     * @param start
     * @param end
     */
    public void mergeSort(int[] ints, int[] merge, int start, int end) {
        if (start >= end) return;

        int mid = (end + start) >> 1;

        mergeSort(ints, merge, start, mid);
        mergeSort(ints, merge, mid + 1, end);

        merge(ints, merge, start, end, mid);

    }

    private void merge(int[] a, int[] merge, int start, int end, int mid) {
        int i = start;
        int j = mid + 1;
        int pos = start;
        while (i <= mid || j <= end) {
            if (i > mid) {
                while (j <= end) merge[pos++] = a[j++];
                break;
            }

            if (j > end) {
                while (i <= mid) merge[pos++] = a[i++];
                break;
            }

            merge[pos++] = a[i] >= a[j] ? a[j++] : a[i++];
        }

        for (pos = start; pos <= end; pos++)
            a[pos] = merge[pos];

    }
}
