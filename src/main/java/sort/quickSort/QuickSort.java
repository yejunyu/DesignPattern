package sort.quickSort;

import sort.CallBack;

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

    public <T extends Comparable<T>> void quick(T[] ts, int left, int right) {
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
                ts[i] = ts[j];
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
}
