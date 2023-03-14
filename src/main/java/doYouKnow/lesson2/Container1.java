package doYouKnow.lesson2;

import java.util.HashSet;
import java.util.Set;

/**
 * 常数时间内完成加水
 * connect 为O(n)
 *
 * @Author yjy
 * @Date 2023/2/22
 **/
public class Container1 {

    Group group = new Group(this);

    public Container1() {
    }

    public double getAmount() {
        return group.amountPerContainer;
    }

    public void connectTo(Container1 other) {
        if (this.group == other.group) {
            return;
        }
        double amount1 = group.amountPerContainer * group.members.size();
        double amount2 = other.group.amountPerContainer * other.group.members.size();

        group.members.addAll(other.group.members);
        group.amountPerContainer = (amount1 + amount2) / group.members.size();
        group.members.forEach(m -> {
            m.group = group;
        });
    }

    public void addWater(double amount) {
        double perAmount = amount / group.members.size();
        group.amountPerContainer += perAmount;
    }

    /**
     * 获取直接或间接的容器数
     *
     * @return
     */
    public int groupSize() {
        return this.group.members.size();
    }

    /**
     * 清空直接或间接的容器
     */
    public void flush() {
        this.group.amountPerContainer = 0;
    }

    private static class Group {
        double amountPerContainer;

        Set<Container1> members;

        public Group(Container1 c) {
            members = new HashSet<>();
            members.add(c);
        }
    }

    public static void main(String[] args) {
        Container1 a = new Container1();
        Container1 b = new Container1();
        Container1 c = new Container1();
        Container1 d = new Container1();
        a.addWater(12);
        d.addWater(8);
        a.connectTo(b);
        b.connectTo(a);
        System.out.println(a.getAmount() + " " + b.getAmount() + " " +
                c.getAmount() + " " + d.getAmount());
        b.connectTo(c);
        System.out.println(a.getAmount() + " " + b.getAmount() + " " +
                c.getAmount() + " " + d.getAmount());
        b.connectTo(d);
        System.out.println(a.getAmount() + " " + b.getAmount() + " " +
                c.getAmount() + " " + d.getAmount());
        b.addWater(4);
        System.out.println(a.getAmount() + " " + b.getAmount() + " " +
                c.getAmount() + " " + d.getAmount());
    }
}
