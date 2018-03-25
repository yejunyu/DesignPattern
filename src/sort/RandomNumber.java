package sort;

import java.util.Random;

/**
 * @author yejunyu
 * @date 2018/3/25.
 */
public class RandomNumber {

    public static int[] createSortNumber(int size, int minNum, int maxNum){
        int[] numArr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numArr[i] = minNum + random.nextInt(maxNum-minNum);
        }
        return numArr;
    }
}
