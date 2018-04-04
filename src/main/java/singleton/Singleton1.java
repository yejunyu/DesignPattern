package singleton;

/**
 * @author yejunyu
 * @date 18-3-21.
 */

/**
 * 饿汉模式
 */
public class Singleton1 {
    //在类内部实例化一个实例
    private static Singleton1 instance = new Singleton1();
    //私有的构造函数,外部无法访问
    private Singleton1() {
    }
    //对外提供获取实例的静态方法
    public static Singleton1 getInstance() {
        return instance;
    }
}
