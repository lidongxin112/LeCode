package com.sort;

import java.util.Arrays;

/**
 * a.将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
 * b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
 * c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
 * <p>
 * 时间复杂度 o(nlog n) 空间复杂度 o(1)
 *
 * @author 东鑫
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 8, 5, 9};
        int length = arr.length;
        //从最后一个非叶节点开始构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maximumHeap(i, arr, length);
        }
        //从最小的叶子节点开始与根节点进行交换并重新构建大顶堆
        for (int i = arr.length - 1; i >= 0; i--) {
//            System.out.println(Arrays.toString(arr));
            swap(arr, 0, i);
            length--;
            maximumHeap(0, arr, length);
        }
        System.out.println(Arrays.toString(arr));
    }

    //构建大顶堆
    public static void maximumHeap(int i, int[] arr, int length) {
        int temp = arr[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            //如果右孩子大于做孩子，则指向右孩子
            if (j + 1 < length && arr[j + 1] > arr[j]) {
                j++;
            }
            //如果最大的孩子大于当前节点，则将大孩子赋给当前节点，修改当前节点为其大孩子节点，再向下走。
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        //将temp放到最终位置
        arr[i] = temp;
    }
    //交换
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
