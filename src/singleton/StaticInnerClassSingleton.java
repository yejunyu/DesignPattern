package singleton;

/**
 * @author yejunyu
 * @date 2018/4/1.
 */
public class StaticInnerClassSingleton {
    /**
     * 在静态内部类中初始化实例对象
     */
    private static class SingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }
    // 私有构造方法
    private StaticInnerClassSingleton() {
    }
    /**
     * 对外提供获取实例的静态方法
     * @return
     */
    public static final StaticInnerClassSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
