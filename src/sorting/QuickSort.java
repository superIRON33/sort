package sorting;

import java.util.Scanner;

/**
 * @ClassName QuickSort.java
 * @Description 快速排序
 * @Author ZBW
 * @Date 2020年03月07日 22:20
 **/
public class QuickSort {
    private static int[] sort(int[] array) {
       quickSort(array, 0, array.length-1);
       return array;
    }
    //对于arr[l....r]部分进行排序
    private static void quickSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(array, l, r);
        quickSort(array, l, p-1);
        quickSort(array, p+1, r);
    }

    //对array[l...r]部分进行partition操作
    //返回p，使得array[l...p-1] < array[p]; array[p+1...r] > arr[p]
    //partition过程也是整个排序算法最为核心的部分
    private static int partition(int[] array, int l, int r) {
        int v = array[l];
        int i = l + 1, j = r;
        while (true) {
            //i向右遍历过程，如果比主元大就停止
            while (i <= j && array[i] <= v) {
                i++;
            }
            //j向左遍历过程，如果比主元小就停止
            while (i <= j && array[j] >= v) {
                j--;
            }
            if (i >= j) {
                break;
            }
            //对二者进行交换
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
        //将arr[j]和主元继进行交换，这样主元之前的元素都小于主元，主元后的元素都大于主元
        array[l] = array[j];
        array[j] = v;
        return j;
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
