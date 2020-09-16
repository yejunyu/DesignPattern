package sort.mergeSort;

import sort.CallBack;

/**
 * @author: YeJunyu
 * @description:
 * @email: yyyejunyu@gmail.com
 * @date: 2019/8/14
 */
public class MergeSort implements CallBack {
    public MergeSort() {
        System.out.println("归并排序");
    }


    @Override
    public <T extends Comparable<T>> T[] sort(T[] ts) {
        mergeSort(ts, 0, ts.length - 1);
        return ts;
    }

    private <T extends Comparable<T>> void mergeSort(T[] ts, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(ts, l, mid);
        mergeSort(ts, mid + 1, r);
        merge(ts, l, mid, r);
    }

    private <T extends Comparable<T>> void merge(T[] ts, int l, int mid, int r) {

    }
}
