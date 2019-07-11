package sort;

import sort.bubbleSort.BubbleSort;
import sort.insertSort.InsertSort;
import sort.selectionSort.SelectionSort;

import java.util.Arrays;

/**
 * @author: YeJunyu
 * @description:
 * @email: yyyejunyu@gmail.com
 * @date: 2019/6/6
 */
public class Main {

    public static void main(String[] args) {
        int size = 10000;
        Integer[] arr = RandomNumber.createSortNumber(size, 100, 200000);
        Integer[] arr1 = Helper.copyArr(arr);
        Integer[] arr2 = Helper.copyArr(arr);
        Integer[] arr3 = Helper.copyArr(arr);
        System.out.println("排序前: " + Arrays.toString(arr));
        Helper.getTime(new SelectionSort(), arr);
        Helper.getTime(new BubbleSort(), arr1);
        Helper.getTime(new InsertSort(), arr2);
    }
}
