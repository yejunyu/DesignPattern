package doYouKnow.lesson2.abtractContainer;

import doYouKnow.lesson2.Container3;

/**
 * @Author yjy
 * @Date 2023/3/27
 **/
public class Container4 extends UnionFindNode<Double, ContainerSummary> {
    public Container4() {
        super(ContainerSummary.ops);
    }

    public static void main(String[] args) {
        Container4 a = new Container4();
        Container4 b = new Container4();
        Container4 c = new Container4();
        Container4 d = new Container4();
        a.update(12D);
        d.update(8D);
        a.connectTo(b);
        System.out.println(a.get() + " " + b.get() + " " +
                c.get() + " " + d.get());
        b.connectTo(c);
        System.out.println(a.get() + " " + b.get() + " " +
                c.get() + " " + d.get());
        d.connectTo(b);
        System.out.println(a.get() + " " + b.get() + " " +
                c.get() + " " + d.get());
        b.update(4d);
        System.out.println(a.get() + " " + b.get() + " " +
                c.get() + " " + d.get());
    }
}
