package sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName HeapSort.java
 * @Description 堆排序
 * @Author ZBW
 * @Date 2020年03月07日 22:21
 **/
public class HeapSort {
    /**
     *  下沉操作，执行删除操作相当于把最后
     *  一个元素赋给根元素之后，然后对根元素执行下沉操作
     */
    public static int[] downAdjust(int[] arr, int parent, int length) {
        //临时保证要下沉的元素
        int temp = arr[parent];
        //定位左孩子节点位置
        int child = 2 * parent + 1;
        //开始下沉
        while (child < length) {
            //如果右孩子节点比左孩子小，则定位到右孩子
            if (child + 1 < length && arr[child] > arr[child + 1]) {
                child++;
            }
            //如果父节点比孩子节点小或等于，则下沉结束
            if (temp <= arr[child]) {
                break;
            }
            //单向赋值
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = temp;
        return arr;
    }

    //堆排序
    public static int[] heapSort(int[] arr, int length) {
        //构建二叉堆
        for (int i = (length - 2) / 2; i >= 0; i--) {
            arr = downAdjust(arr, i, length);
        }
        //进行堆排序
        for (int i = length - 1; i >= 1; i--) {
            //把堆顶的元素与最后一个元素交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //下沉调整
            arr = downAdjust(arr, 0, i);
        }
        return arr;
    }
    //测试
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
        array = heapSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
