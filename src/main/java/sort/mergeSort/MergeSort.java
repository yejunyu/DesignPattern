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

    private <T extends Comparable> void mergeSort(T[] ts, int l, int r) {

    }
}
