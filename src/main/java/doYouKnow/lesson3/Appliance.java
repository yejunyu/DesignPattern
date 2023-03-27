package doYouKnow.lesson3;

import javax.swing.text.Utilities;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author yjy
 * @Date 2023/3/13
 **/
public class Appliance {
    /**
     * 额定功率
     */
    int power;

    boolean state;
    /**
     * 已接入的电网
     */
    Grid grid;

    public void plugInto(Grid grid) {
        if (this.grid != null) {
            if (state) {
                this.grid.power -= this.power;
            }
            this.grid.appliances.remove(this);
        }
        this.grid = grid;
        grid.appliances.add(this);
    }

    public void on() {
        List<String> a = new ArrayList<>();
        Set<String> b = new HashSet<>();
        if (this.grid.power + this.power > this.grid.maxPower) {
            throw new RuntimeException("功率过大");
        }
        state = true;
        this.grid.power += this.power;
    }

    public void off() {
        state = false;
        this.grid.power -= this.power;
    }

    public Appliance(int power) {
        this.power = power;
    }

    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("24");
        BigInteger gcd = bigInteger.gcd(BigInteger.TWO);
        System.out.println(gcd);
    }


}
