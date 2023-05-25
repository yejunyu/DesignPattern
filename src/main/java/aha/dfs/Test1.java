package aha.dfs;

/**
 * @Author yjy
 * @Date 2023/5/19
 **/
public class Test1 {
    /**
     * 3个盒子
     */
    static int n = 3;
    static int book[] = new int[n + 1];
    static int a[] = new int[n + 1];

    static void dfs(int step) {
        // 如果站在第n+1盒子面前,代表前面n个盒子已经放好了
        if (step == n + 1) {
            // 输出排列
            for (int i = 1; i <= n; i++) {
                System.out.printf("%d", a[i]);
            }
            System.out.println();
            // 返回之前的一步
            return;
        }
        for (int i = 1; i <= n; i++) {
            // 0代表卡还在手上
            if (book[i] == 0) {
                // 将i号牌放到第step盒子里
                a[step] = i;
                // 卡已经不在手上了
                book[i] = 1;
                dfs(step + 1);
                // 将刚才的牌收回
                book[i] = 0;
            }
        }
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0 || n == 1) {
            return true;
        }
        if (n % 2 == 1) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
//        dfs(1);
        System.out.println(isPowerOfTwo(8));
    }
}
