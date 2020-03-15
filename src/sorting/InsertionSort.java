package sorting;

import java.util.Scanner;

/**
 * @ClassName InsertionSort.java
 * @Description 插入排序
 * @Author ZBW
 * @Date 2020年03月06日 21:22
 **/
public class InsertionSort {

    private static int[] sort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int k = i - 1;
            while (k >= 0 && array[k] > temp) {
                k--;
            }
            //k+1到i之前的元素都右移，来把k+1空出来
            for (int j = i; j > k + 1; j--) {
                array[j] = array[j-1];
            }
            //在索引为k+1的地方插入
            array[k+1] = temp;
        }
        return array;
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
