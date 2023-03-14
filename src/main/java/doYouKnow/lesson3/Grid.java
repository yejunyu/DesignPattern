package doYouKnow.lesson3;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author yjy
 * @Date 2023/3/13
 **/
public class Grid {
    /**
     * 最大支持功率
     */
    int maxPower;

    /**
     * 已接入功率
     */
    int power;

    Set<Appliance> appliances = new HashSet<>();

    public Grid(int maxPower) {
        this.maxPower = maxPower;
    }

    public int residualPower() {
        return maxPower - power;
    }


    public static void main(String[] args) {
        Appliance tv = new Appliance(150);
        Appliance radio = new Appliance(30);
        Grid grid = new Grid(3000);
        tv.plugInto(grid);
        radio.plugInto(grid);
        System.out.println(grid.residualPower());
        tv.on();
        System.out.println(grid.residualPower());
        radio.on();
        System.out.println(grid.residualPower());
        radio.off();
        System.out.println(grid.residualPower());
    }
}
