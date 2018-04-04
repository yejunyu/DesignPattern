package singleton;

/**
 * @author yejunyu
 * @date 2018/4/2.
 */
/**
 * 线程A发现变量没有被初始化, 然后它获取锁并开始变量的初始化。

 由于某些编程语言的语义，编译器生成的代码允许在线程A执行完变量的初始化之前，更新变量并将其指向部分初始化的对象。

 线程B发现共享变量已经被初始化，并返回变量。由于线程B确信变量已被初始化，它没有获取锁。如果在A完成初始化之前共享变量对B可见
 （这是由于A没有完成初始化或者因为一些初始化的值还没有穿过B使用的内存(缓存一致性)），程序很可能会崩溃。
 */
class FinalWrapper<T> {
    public final T value;

    FinalWrapper(T value) {
        this.value = value;
    }
}

public class FinalSingleton {
    private FinalWrapper<FinalSingleton> helperWrapper = null;

    public FinalSingleton getHelper(){
        FinalWrapper<FinalSingleton> wrapper = helperWrapper;

        if (null == wrapper){
            synchronized (this){
                if (null == helperWrapper){
                    helperWrapper = new FinalWrapper<FinalSingleton>(new FinalSingleton());
                }
                wrapper = helperWrapper;
            }
        }
        return wrapper.value;
    }
}
