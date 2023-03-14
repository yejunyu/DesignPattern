package sort.test;

import java.util.*;

/**
 * 小猫钓鱼游戏
 *
 * @Author yjy
 * @Date 2023/2/21
 **/
public class Test3 {
    // 241256
    // 313564

    static Deque<Integer> a = new ArrayDeque<>();
    static Deque<Integer> b = new ArrayDeque<>();

    static {
        a.addAll(Arrays.asList(2, 4, 1, 2, 5, 6));
        b.addAll(Arrays.asList(3, 1, 3, 5, 6, 4));
    }

    static Deque<Integer> flow = new ArrayDeque<>();
    static List<Integer> temp = new ArrayList<>();

    public static void chupai(User user) {
        Integer i = user.handCards.pollFirst();
        System.out.println(user.name + "出了一张: [" + i + "]" + "还剩: " + user.handCards);
        if (flow.contains(i)) {
            temp.add(i);
            System.out.print("分配了: ");
            for (int j = 0; j < flow.size(); j++) {
                Integer p = flow.pollFirst();
                temp.add(p);
                System.out.print(p + " ");
                if (Objects.equals(p, i)) {
                    break;
                }
            }
            user.handCards.addAll(temp);
            temp = new ArrayList<>();
            System.out.println();
        } else {
            flow.addFirst(i);
        }
    }

    public static void main(String[] args) {
        User A = new User("A", a);
        User B = new User("B", b);
        while (true) {
            chupai(A);
            chupai(B);
            if (A.handCards.isEmpty() || B.handCards.isEmpty()) {
                break;
            }
        }
    }

    public static class User {
        String name;
        Deque<Integer> handCards;

        public User(String name, Deque<Integer> handCards) {
            this.name = name;
            this.handCards = handCards;
        }
    }
}
