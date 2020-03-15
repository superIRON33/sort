package sorting;

import java.util.Scanner;

/**
 * @ClassName HillSort.java
 * @Description 希尔排序
 * @Author ZBW
 * @Date 2020年03月07日 19:20
 **/
public class HillSort {
    public static int[] sort(int array[]) {
        if (array == null || array.length < 2) {
            return array;
        }
        int n = array.length;
        // 对每组间隔为 h的分组进行排序，刚开始 h = n / 2;
        for (int h = n / 2; h > 0; h /= 2) {
            //对各个局部分组进行插入排序
            for (int i = h; i < n; i++) {
                // 将array[i] 插入到所在分组的正确位置上
                insert(array, h, i);
            }
        }
        return array;
    }

    /**
     * 将array[i]插入到所在分组的正确位置上
     * array[i]] 所在的分组为 ... array[i-2*h],array[i-h], array[i+h] ...
     */
    private static void insert(int[] array, int h, int i) {
        int temp = array[i];
        int k;
        for (k = i - h; k > 0 && temp < array[k]; k -= h) {
            array[k + h] = array[k];
        }
        array[k + h] = temp;
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
