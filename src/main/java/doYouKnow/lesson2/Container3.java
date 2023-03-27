package doYouKnow.lesson2;

/**
 * 并查集算法
 * 父指针树
 * 父指针树是一个链式数据结构，其中每个节点恰好都指向另一个节点，称为它的父节点，
 * 除了一个称为根节点的特殊节点，它不指向任何其他节点（见图 3-5）。同时，所有节点都可
 * 以通过跟随指针到达根节点。这些约束条件保证了指针不会形成循环，所以树是一种特殊类
 * 型的有向无环图（DAG）。
 *
 * @Author yjy
 * @Date 2023/2/22
 **/
public class Container3 {

    private double amount;

    private Container3 parent = this;

    private int size = 1;

    public Container3() {
    }

    public Container3 findRootAndCompress() {
        if (parent != this) {
            parent = parent.findRootAndCompress();
        }
        return parent;
    }

    public double getAmount() {
        Container3 root = findRootAndCompress();
        return root.amount;
    }


    public void connectTo(Container3 other) {
        Container3 root1 = findRootAndCompress();
        Container3 root2 = other.findRootAndCompress();
        int size = root1.size + root2.size;
        if (root1.size >= root2.size) {
            // 假如root1的节点多, root2挂到root1上去
            root2.parent = root1;
            root1.amount = (root1.amount * root1.size + root2.amount * root2.size) / size;
            root1.size = size;
        } else {
            root1.parent = root2;
            root2.amount = (root1.amount * root1.size + root2.amount * root2.size) / size;
            root2.size = size;
        }
    }

    public void addWater(double amount) {
        Container3 root = findRootAndCompress();
        root.amount += amount / root.size;
    }

    /**
     * 获取直接或间接的容器数
     *
     * @return
     */
    public int groupSize() {
        Container3 root = findRootAndCompress();
        return root.size;
    }

    /**
     * 清空直接或间接的容器
     */
    public void flush() {
        Container3 root = findRootAndCompress();
        root.amount = 0;
    }

    public static void main(String[] args) {
        Container3 a = new Container3();
        Container3 b = new Container3();
        Container3 c = new Container3();
        Container3 d = new Container3();
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
