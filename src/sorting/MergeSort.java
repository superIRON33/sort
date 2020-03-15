package sorting;

import java.util.Scanner;

/**
 * @ClassName MergeSort.java
 * @Description 归并排序递归版本
 * @Author ZBW
 * @Date 2020年03月07日 22:18
 **/
public class MergeSort {

    private static int[] sort(int[] array) {
        merge(array, 0, array.length - 1);
        return array;
    }
    //递归使用归并排序，对array[l...r]的范围进行排序
    private static void merge(int[] array, int l, int r){
        if (l >= r) {
            return;
        }
        int mid = (l + r)/2;
        merge(array, l, mid);
        merge(array, mid + 1, r);
        //此处是一种优化，对于整体数组基本有序时的优化
        if (array[mid] > array[mid+1]) {
            mergeAll(array, l, mid, r);
        }
    }
    //将array[l...mid]和array[mid+1...r]两部分进行归并
    private static void mergeAll(int[] array, int l, int mid, int r) {
        int[] temp = new int[r-l+1];
        for (int i = l; i <= r; i++) {
            temp[i-l] = array[i];
        }
        int i = l, j = mid+1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                array[k] = temp[j-l];
                j++;
            } else if (j > r) {
                array[k] = temp[i-l];
                i++;
            } else if (temp[i-l] < temp[j-l]) {
                array[k] = temp[i-l];
                i++;
            } else {
                array[k] = temp[j-l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入待排序数据个数：");
        //输入需要排序的数据个数
        int n = in.nextInt();
        int[] array = new int[n];
        System.out.println("请输入待排序数据：");
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        int[] res = sort(array);
        print(res);
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
