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
        System.out.println("执行时间为: " + (endTime - startTime));
        System.out.println("排序后: " + Arrays.toString(a));
    }
}
