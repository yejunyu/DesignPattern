package doYouKnow.lesson2;

/**
 * 常数时间内完成添加连接
 * connect 为O(n)
 *
 * @Author yjy
 * @Date 2023/2/22
 **/
public class Container2 {

    private double amount;

    private Container2 next = this;

    public Container2() {
    }

    public double getAmount() {
        // 此方法用于重新分配水
        updateGroup();
        return amount;
    }

    /**
     * 重新分配水
     */
    private void updateGroup() {
        Container2 current = this;
        double totalAmount = 0;
        int groupSize = 0;
        do {
            totalAmount += current.amount;
            groupSize++;
            current = current.next;
        } while (current != this);
        double amount = totalAmount / groupSize;
        do {
            current.amount = amount;
            current = current.next;
        } while (current != this);

    }

    public void connectTo(Container2 other) {
        Container2 oldNext = next;
        next = other.next;
        other.next = oldNext;
    }

    public void addWater(double amount) {
        // 仅更新当前容器的水量, 在获取水量时才分配
        this.amount += amount;
    }


    /**
     * 获取直接或间接的容器数
     *
     * @return
     */
    public int groupSize() {
        int size = 0;
        Container2 current = this;
        do {
            size++;
            current = current.next;
        } while (this != current);
        return size;
    }

    /**
     * 清空直接或间接的容器
     */
    public void flush() {
        Container2 current = this;
        do {
            current.amount = 0;
            current = current.next;
        } while (this != current);
    }

    public static void main(String[] args) {
        Container2 a = new Container2();
        Container2 b = new Container2();
        Container2 c = new Container2();
        Container2 d = new Container2();
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
