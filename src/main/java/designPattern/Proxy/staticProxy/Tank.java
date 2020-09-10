package designPattern.Proxy.staticProxy;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author: yejunyu
 * date: 2018/8/22
 */
public class Tank implements Moveable {

    @Override
    public void move() {
        System.out.println("Tank moving...");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
