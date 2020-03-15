package sorting;

import java.util.Scanner;

/**
 * @ClassName SelectionSort.java
 * @Description 选择排序
 * @Author ZBW
 * @Date 2020年03月06日 20:26
 **/
public class SelectionSort {
    public static int[] sort(int n, int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] <= array[index]) {
                    index = j;
                }
            }
            int temp = 0;
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
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
        int[] res = sort(n, array);
        print(res);
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
