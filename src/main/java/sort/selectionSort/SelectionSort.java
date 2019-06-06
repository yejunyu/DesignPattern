package sort.selectionSort;

import sort.CallBack;

/**
 * @author yejunyu
 * @date 2018/3/25.
 */
public class SelectionSort implements CallBack {
    public SelectionSort() {
        System.out.println("选择排序");
    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] ts) {
        int min;
        T temp;
        for (int i = 0, size = ts.length; i < size; i++) {
            // 初始化未排序序列中最小数据数组下标
            min = i;
            for (int j = i + 1; j < size; j++) {
                // 在未排序元素中继续寻找最小元素，并保存其下标
                if (ts[j].compareTo(ts[min]) < 0) {
                    min = j;
                }
            }
            // 将未排序列中最小元素放到已排序列末尾
            if (min != i) {
                temp = ts[min];
                ts[min] = ts[i];
                ts[i] = temp;
            }
        }
        return ts;
    }
}
