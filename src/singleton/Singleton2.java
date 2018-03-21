package singleton;

/**
 * @author yejunyu
 * @date 18-3-21.
 */

/**
 * 懒汉模式
 */
public class Singleton2 {
    private Singleton2 instance;

    private Singleton2() {}

    public Singleton2 getInstance(){
        if (null == instance){
            instance = new Singleton2();
        }
        return instance;
    }
}
