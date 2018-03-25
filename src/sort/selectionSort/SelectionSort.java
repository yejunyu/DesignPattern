package sort.selectionSort;

import sort.RandomNumber;

import java.util.Arrays;

/**
 * @author yejunyu
 * @date 2018/3/25.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int n = 100;
        int size = 10;
        int[] arrNum = RandomNumber.createSortNumber(size,0,n);
        for (int i = 0; i < size; i++) {
            int minIndex = i;
            for (int j = i+1; j < size; j++) {
                if (arrNum[j] < arrNum[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arrNum[i];
            arrNum[i] = arrNum[minIndex];
            arrNum[minIndex] = temp;
        }
        System.out.println(Arrays.toString(arrNum));
    }
}
