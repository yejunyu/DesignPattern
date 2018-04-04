package main.java.aop.proxy;

/**
 * @author yejunyu
 * @date 2018/4/4.
 */
public class Main {

    /**
     * 目标对象必须实现接口
     * 返回创建的代理对象
     * 重写 invoke() 方法
     * 限制条件就可以放在 invoke 中
     * @param args
     */
    public static void main(String[] args) {
        IStudent s1 = new StudentBean();
        ProxyFactory factory = new ProxyFactory();
        IStudent s2 = (IStudent) factory.createStudentProxy(s1);
        s2.print();
    }
}
