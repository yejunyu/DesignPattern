package doYouKnow.lesson2;

import java.util.Objects;

/**
 * ultimate版
 *
 * @Author yjy
 * @Date 2023/2/22
 **/
public class Container {

    private double amount;

    private Container parent = this;

    private int size = 1;

    public Container() {
    }

    public Container findRootAndCompress() {
        if (parent != this) {
            parent = parent.findRootAndCompress();
        }
        return parent;
    }

    public double getAmount() {
        Container root = findRootAndCompress();
        return root.amount;
    }


    public void connectTo(Container other) {
        // 前置条件检查
        Objects.requireNonNull(other, "容器不能为null");
        Container root1 = findRootAndCompress(), root2 = other.findRootAndCompress();
        if (root1 == root2) return;
        // 容器连接
        if (root1.size <= root2.size) {
            root1.linkTo(root2);
        } else {
            root2.linkTo(root1);
        }
    }

    private void linkTo(Container otherRoot) {
        parent = otherRoot;
        otherRoot.amount = combinedAmount(otherRoot);
        otherRoot.size += size;
    }

    private double combinedAmount(Container otherRoot) {
        return ((amount * size) + (otherRoot.amount * otherRoot.size)) / (size + otherRoot.size);
    }

    public void addWater(double amount) {
        Container root = findRootAndCompress();
        double amountPerContainer = amount / root.size;
        if (root.amount + amountPerContainer < 0) {
            throw new IllegalArgumentException("水不足");
        }
        root.amount += amountPerContainer;
    }

    /**
     * 获取直接或间接的容器数
     *
     * @return
     */
    public int groupSize() {
        Container root = findRootAndCompress();
        return root.size;
    }

    /**
     * 清空直接或间接的容器
     */
    public void flush() {
        Container root = findRootAndCompress();
        root.amount = 0;
    }

    public static void main(String[] args) {
        Container a = new Container();
        Container b = new Container();
        Container c = new Container();
        Container d = new Container();
        a.addWater(12);
        d.addWater(8);
        a.connectTo(b);
        System.out.println(a.getAmount() + " " + b.getAmount() + " " +
                c.getAmount() + " " + d.getAmount());
        b.connectTo(c);
        System.out.println(a.getAmount() + " " + b.getAmount() + " " +
                c.getAmount() + " " + d.getAmount());
        d.connectTo(b);
        System.out.println(a.getAmount() + " " + b.getAmount() + " " +
                c.getAmount() + " " + d.getAmount());
        b.addWater(4);
        System.out.println(a.getAmount() + " " + b.getAmount() + " " +
                c.getAmount() + " " + d.getAmount());
    }
}
