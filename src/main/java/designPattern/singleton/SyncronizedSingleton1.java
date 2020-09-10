package designPattern.singleton;

/**
 * @author yejunyu
 * @date 18-3-21.
 */

/**
 * 懒汉模式
 */
public class SyncronizedSingleton1 {
    private static SyncronizedSingleton1 instance;

    private SyncronizedSingleton1() {}

    // 范围更小的锁
    public static SyncronizedSingleton1 getInstance(){
        if (null == instance){
            synchronized (SyncronizedSingleton1.class){
                instance = new SyncronizedSingleton1();
            }
        }
        return instance;
    }
}
