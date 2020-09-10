package designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yejunyu
 * date: 2018/9/7
 */
public class Feed implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new News.NYTimes());
        f.registerObserver(new News.Guardian());
        f.registerObserver(new News.Lemonde());
        f.notifyObservers("The queen said her favourite book is Java 8 in Action!+money");

        /**
         * lambda 简化,提取出公用的 notify 的抽象
         */
        f.registerObserver(new Observer() {
            @Override
            public void notify(String tweet) {
                if (tweet != null && tweet.contains("money")) {
                    System.out.println("Breaking news in NY! " + tweet);
                }
            }
        });
        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London... " + tweet);
            }
        });
    }

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}
