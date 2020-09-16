package designPattern.singleton;

/**
 * @author yejunyu
 * @date 2018/4/2.
 */
public class SingletonEnum {

    private SingletonEnum() {
    }

    private enum singleton {
        INSTANCE;

        private final SingletonEnum instance;

        singleton() {
            instance = new SingletonEnum();
        }
    }

    public SingletonEnum getInstance() {
        return singleton.INSTANCE.instance;
    }
}
