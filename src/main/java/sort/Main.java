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
        Integer[] arr = RandomNumber.createSortNumber(10000, 100, 200000);
        System.out.println("排序前: " + Arrays.toString(arr));
        Helper.getTime(new SelectionSort(), arr);
        Helper.getTime(new BubbleSort(), arr);
        Helper.getTime(new InsertSort(), arr);
    }
}
