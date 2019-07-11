package sort.insertSort;

import sort.CallBack;

/**
 * @author yejunyu
 * @date 2018/3/25.
 */
public class InsertSort implements CallBack {

    public InsertSort() {
        System.out.println("插入排序");
    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] ts) {
        // 第一版本的插入排序,在第二层循环需要交换多次(性能损耗在交换上了)
//        // 第0个元素已经有序了
//        for (int i = 1, size = ts.length; i < size; i++) {
//            // 寻找arr[i]合适的插入位置,从i位置向前找
//            for (int j = i; j > 0 && ts[j].compareTo(ts[j - 1]) < 0; j--) {
//                T temp = ts[j];
//                ts[j] = ts[j - 1];
//                ts[j - 1] = temp;
//            }
//        }
        // 第二版本的插入排序,先复制一份arr[i],只做一次交换操作
        for (int i = 1, size = ts.length; i < size; i++) {
            T e = ts[i];
            int j; // 保存元素e应该插入的位置
            for (j = i; j > 0 && ts[j - 1].compareTo(e) > 0; j--) {
                ts[j] = ts[j - 1];
            }
            ts[j] = e;
        }
        return ts;
    }
}
