package sort;

/**
 * @author: YeJunyu
 * @description:
 * @email: yyyejunyu@gmail.com
 * @date: 2019/6/6
 */
public interface CallBack {
    <T extends Comparable<T>> T[] sort(T[] ts);
}
