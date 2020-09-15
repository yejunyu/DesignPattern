package sort.quickSort;

import sort.CallBack;
import sort.Helper;
import sort.RandomNumber;

import java.util.Arrays;

/**
 * @author: YeJunyu
 * @description: 快排
 * @email: yyyejunyu@gmail.com
 * @date: 2020/9/14
 */
public class QuickSort implements CallBack {

    public QuickSort() {
        System.out.println("快速排序");
    }

    private static <T extends Comparable> void quick(T[] ts, int left, int right) {
        if (left > right) {
            return;
        }
        T pivot = ts[left];
        int i = left, j = right;
        while (i != j) {
            while (ts[j].compareTo(ts[left]) >= 0 && i < j) {
                j--;
            }
            while (ts[i].compareTo(ts[left]) <= 0 && i < j) {
                i++;
            }
            if (i < j) {
                T temp = ts[i];
                ts[i] = temp;
                ts[j] = temp;
            }
        }
        ts[left] = ts[i];
        ts[i] = pivot;
        quick(ts, left, i - 1);
        quick(ts, i + 1, right);
    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] ts) {
        quick(ts, 0, ts.length - 1);
        return ts;
    }

    public static void main(String[] args) {
        int size = 10;
        Integer[] arr = RandomNumber.createSortNumber(size, 100, 200000);
        Integer[] arr1 = Helper.copyArr(arr);
        System.out.println("排序前: " + Arrays.toString(arr));
//        Thread.sleep(20_000L);
        Helper.getTime(new QuickSort(), arr);
        QuickSort q = new QuickSort();
        Integer[] arr2 = new Integer[]{146944, 86014, 111975, 198014, 121709, 146944, 151141, 154431, 163805, 198014};
        Integer[] sort = q.sort(arr2);
        System.out.println(Arrays.toString(sort));

    }
}
