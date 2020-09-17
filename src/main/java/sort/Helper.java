package sort;

import java.util.Arrays;

/**
 * @author: YeJunyu
 * @description:
 * @email: yyyejunyu@gmail.com
 * @date: 2019/6/6
 */
public class Helper {
    public static <T extends Comparable<T>> void getTime(CallBack callBack, T[] arr) {
        long startTime = System.currentTimeMillis();
        T[] a = callBack.sort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间为: " + (endTime - startTime) + " ms");
        print(a);
        System.out.println("......");
    }

    private static <T> void print(T[] a) {
        int length = a.length;
        int n = 20;
        if (length > n) {
            for (int i = 0; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
        } else {
            System.out.println(Arrays.toString(a));
        }

    }

    public static Integer[] copyArr(Integer[] arr) {
        int size = arr.length;
        return Arrays.copyOf(arr, size);
    }
}
