package aoi;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author yjy
 * @Date 2023/2/21
 **/
public class Aoi {
    /**
     * 10*10的格子
     */
    static final int upLimit = 0;
    static final int downLimit = 9;

    static final int unit = 10;

    public static int getSerial(int x, int y) {
        // 先计算本格序号
        return x * unit + y;
    }


    public static Map<Integer, User> map = new HashMap<>();

    public static void add(User user) {
        map.put(getSerial(user.x, user.y), user);
    }


    public static void main(String[] args) {
        Random r = new Random();
        User A = new User("A", r.nextInt(unit), r.nextInt(unit));
        add(A);
        User B = new User("A", r.nextInt(unit), r.nextInt(unit));
        add(B);
        User C = new User("A", r.nextInt(unit), r.nextInt(unit));
        add(C);
        User D = new User("A", r.nextInt(unit), r.nextInt(unit));
        add(D);
        User E = new User("A", r.nextInt(unit), r.nextInt(unit));
        add(E);
        System.out.println(map);
    }

    public static class User {
        String name;
        int x;
        int y;

        public User(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
