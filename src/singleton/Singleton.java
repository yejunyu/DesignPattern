package singleton;

import java.io.Serializable;

/**
 * @author yejunyu
 * @date 2018/4/2.
 */
public class Singleton implements Serializable{
    private volatile static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){
        if (null == instance){
            synchronized (Singleton.class){
                instance = new Singleton();
            }
        }
        return instance;
    }

    private Object readResolve(){
        return instance;
    }
}
