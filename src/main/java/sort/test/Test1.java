package sort.test;

/**
 * @Author yjy
 * @Date 2023/2/1
 **/
public class Test1 {

    /**
     * 桶排序做法
     *
     * @param arr
     */
    public static void test1(int[] arr) {
        int[] a = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            a[arr[i]] = a[arr[i]] + 1;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * 输入 10个数 20 40 32 67 40 20 89 300 400 15
     * 重复的数字只输出1次
     * 输出有几个数,按从小到大排序
     * 15 20 32 40 67 89 300 400
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = new int[]{20, 40, 32, 67, 40, 20, 89, 300, 400, 15};
        test1(a);


    }
}
