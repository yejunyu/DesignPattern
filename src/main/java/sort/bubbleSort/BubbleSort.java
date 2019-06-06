package sort.bubbleSort;

import sort.CallBack;

/**
 * @author yejunyu
 * @date 2018/3/25.
 */
public class BubbleSort implements CallBack {
    public BubbleSort() {
        System.out.println("冒泡排序");
    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] ts) {
        for (int i = 0, size = ts.length; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (ts[j].compareTo(ts[j + 1]) > 0) {
                    T temp = ts[j];
                    ts[j] = ts[j + 1];
                    ts[j + 1] = temp;
                }
            }
        }
        return ts;
    }
}
