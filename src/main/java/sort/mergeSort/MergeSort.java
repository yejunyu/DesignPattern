package sort.mergeSort;

import sort.CallBack;

import java.lang.reflect.Array;
import java.util.Arrays;

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
        if (ts[mid].compareTo(ts[mid + 1]) >= 0) {
            merge(ts, l, mid, r);
        }
    }

    private <T extends Comparable<T>> void merge(T[] ts, int l, int mid, int r) {
        T[] aux = (T[]) Array.newInstance(ts.getClass().getComponentType(), r - l + 1);
        // 复制一个数组用于辅助调整位置
        for (int i = l; i < r + 1; i++) {
            aux[i - l] = ts[i];
        }
        int i = l, j = mid + 1;
        for (int k = l; k < r + 1; k++) {
            if (i > mid) {
                ts[k] = aux[j - l];
                j++;
            } else if (j > r) {
                ts[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) >= 0) {
                ts[k] = aux[j - l];
                j++;
            } else {
                ts[k] = aux[i - l];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{999, 12, 3, 2, 1, 19};
        MergeSort m = new MergeSort();
        m.mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
