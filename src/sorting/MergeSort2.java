package sorting;

import java.util.Scanner;

/**
 * @ClassName MergeSort2.java
 * @Description //TODO
 * @Author ZBW
 * @Date 2020年03月08日 20:53
 **/
public class MergeSort2 {

    public static int[] sort(int[] array) {

        for (int size = 1; size <= array.length; size += size) {
            for (int i = 0; i < array.length; i += size + size) {
                mergeAll(array, i, i+size-1, Math.min(i+size+size-1, array.length-1));
            }
        }
        return array;
    }

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
