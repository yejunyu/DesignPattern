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
        System.out.println("排序后: " + Arrays.toString(a));
    }

    public static Integer[] copyArr(Integer[] arr) {
        int size = arr.length;
        return Arrays.copyOf(arr, size);
    }
}
