package observer;

/**
 * @author: yejunyu
 * date: 2018/9/7
 */
public interface Subject {
    void registerObserver(Observer o);

    void notifyObservers(String tweet);
}
