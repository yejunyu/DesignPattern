package doYouKnow.lesson3;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个int类,对一个证书列表进行汇总和统计
 * 快速查询的选择
 *
 * @Author yjy
 * @Date 2023/3/4
 **/
public class IntStates2 {

    List<Integer> data;

    double sum;

    public IntStates2() {
        data = new ArrayList<>();
    }

    public void insert(int n) {
        int i = 0;
        for (Integer num : data) {
            if (num >= n) {
                break;
            }
            i++;
        }
        data.add(i, n);
        sum += n;
    }

    public double getAverage() {
        if (data.size() != 0) {
            return sum / data.size();
        } else {
            return 0;
        }
    }

    /**
     * 2, 10, 11, 20, 100 的中位数是 11
     * 例如，2, 10, 11, 20 的中位数是 10.5
     *
     * @return
     */
    public double getMedian() {
        int middle = data.size() / 2;
        if (data.size() % 2 == 1) {
            return data.get(middle);
        } else {
            return (data.get(middle) + data.get(middle - 1)) / 2.0;
        }
    }

    public static void main(String[] args) {
        IntStates2 intStates1 = new IntStates2();
        intStates1.insert(5);
        intStates1.insert(6);
        intStates1.insert(8);
        intStates1.insert(9);
        System.out.println("avg: " + intStates1.getAverage() + " middle: " + intStates1.getMedian());
        intStates1.insert(7);
        intStates1.insert(9);
        intStates1.insert(10);
        System.out.println("avg: " + intStates1.getAverage() + " middle: " + intStates1.getMedian());
    }
}
