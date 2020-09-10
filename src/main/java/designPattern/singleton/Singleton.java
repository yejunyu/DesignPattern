package designPattern.singleton;

import java.io.Serializable;

/**
 * @author yejunyu
 * @date 2018/4/2.

 * 序列化的源码
 * obj = desc.isInstantiable() ? desc.newInstance() : null;
 * 序列化是通过反射调用无参构造器创建一个新的对象
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
