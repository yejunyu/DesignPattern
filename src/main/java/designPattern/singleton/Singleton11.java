package designPattern.singleton;

/**
 * @author yejunyu
 * @date 18-3-21.
 */

/**
 * 第二种饿汉模式
 */

/**
 * 饿汉式单例，在类被加载的时候对象就会实例化。
 * 这也许会造成不必要的消耗，因为有可能这个实例根本就不会被用到。
 * 而且，如果这个类被多次加载的话也会造成多次实例化。其实解决这个问题的方式有很多，下面提供两种解决方式，
 * 第一种是使用静态内部类的形式。第二种是使用懒汉式。
 */
public class Singleton11 {
    private static Singleton11 instance;
    static {
        instance = new Singleton11();
    }
    private Singleton11() {
    }
    public static Singleton11 getInstance() {
        return instance;
    }
}
