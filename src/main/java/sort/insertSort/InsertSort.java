package sort.insertSort;

import sort.RandomNumber;

import java.util.Arrays;

/**
 * @author yejunyu
 * @date 2018/3/25.
 */
public class InsertSort {

    public static void main(String[] args) {
        int n = 100;
        int size = 10;
        int[] arrNum = RandomNumber.createSortNumber(size,0,n);
        for (int i = 0; i < size; i++) {

        }
        System.out.println(Arrays.toString(arrNum));
    }
}
