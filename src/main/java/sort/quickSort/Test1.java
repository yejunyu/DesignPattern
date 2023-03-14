package sort.quickSort;

import java.util.Arrays;

/**
 * @Author yjy
 * @Date 2023/2/1
 **/
public class Test1 {

    public static void quickSort(int[] arr, int l, int r) {
        // i,j 两个指针
        int i = l;
        int j = r;
        if (i >= j) {
            return;
        }
        // 游标的数
        int p = l;
        while (i != j) {
            while (arr[j] >= arr[p] && i < j) {
                j--;
            }
            while (arr[i] <= arr[p] && i < j) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, p, i);
        quickSort(arr, l, i - 1);
        quickSort(arr, j + 1, r);
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 1, 16, 96, 86, 76, 66, 6, 6, 6};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(Arrays.stream(a).toArray()));
    }
}
