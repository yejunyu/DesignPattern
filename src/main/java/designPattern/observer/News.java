package designPattern.observer;

/**
 * @author: yejunyu
 * date: 2018/9/7
 */
public class News {
    static class NYTimes implements Observer {
        @Override
        public void notify(String tweet) {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY " + tweet);
            }
        }
    }

    static class Guardian implements Observer {
        @Override
        public void notify(String tweet) {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London... " + tweet);
            }

        }
    }

    static class Lemonde implements Observer {
        @Override
        public void notify(String tweet) {
            if (tweet != null && tweet.contains("wine")) {
                System.out.println("Today cheese, wine and news! " + tweet);
            }

        }
    }
}
