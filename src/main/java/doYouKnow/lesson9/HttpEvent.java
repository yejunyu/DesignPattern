package doYouKnow.lesson9;

/**
 * @Author yjy
 * @Date 2023/3/28
 **/
public class HttpEvent implements Event {
    @Override
    public void start() {
        System.out.println("启动了http");
    }

    @Override
    public void stop() {
        System.out.println("停止了http");
    }
}
