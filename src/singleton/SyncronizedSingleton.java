package singleton;

/**
 * @author yejunyu
 * @date 18-3-21.
 */

/**
 * 懒汉模式
 */
public class SyncronizedSingleton {
    private static SyncronizedSingleton instance;

    private SyncronizedSingleton() {}

    // 对方法加锁
    public static synchronized SyncronizedSingleton getInstance(){
        if (null == instance){
            instance = new SyncronizedSingleton();
        }
        return instance;
    }
}
