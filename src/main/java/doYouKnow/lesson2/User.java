package doYouKnow.lesson2;

import java.util.*;

/**
 * 实现 User 类，在社交网络中代表一个人，具有以下功能。
 *  每个用户都有一个名字。提供一个接收这个名字的 public 构造函数。
 *  用户可以使用下面的方法相互结交。
 * public void befriend(User other)
 * 友谊是对称的：a.befriend(b)等同于 b.befriend(a)。
 *  客户端可以通过以下两个方法检查两个用户是直接好友还是间接好友（朋友的朋友）。
 * public boolean isDirectFriendOf(User other)
 * public boolean isIndirectFriendOf(User other)
 *
 * @Author yjy
 * @Date 2023/2/22
 **/
public class User {
    String name;

    Set<User> directFriend;

    public User(String name) {
        this.name = name;
        directFriend = new HashSet<>();
    }

    public void befriend(User other) {
        directFriend.add(other);
        other.directFriend.add(this);
    }

    public boolean isDirectFriendOf(User other) {
        return this.directFriend.contains(other);
    }

    public boolean isIndirectFriendOf(User other) {
        // 已经访问过的结点(又称关闭结点)
        Set<User> visited = new HashSet<>();
        // 表示等待访问的结点
        Deque<User> fronted = new LinkedList<>();
        fronted.add(this);
        while (!fronted.isEmpty()) {
            User user = fronted.removeFirst();
            // 相同说明有这个间接的朋友
            if (user.equals(other)) {
                return true;
            }
            // 排除掉已经判断过的人
            if (visited.add(user)) {
                fronted.addAll(user.directFriend);
            }

        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static void main(String[] args) {
        User a = new User("a");
        User b = new User("b");
        User c = new User("c");
        User d = new User("d");
        a.befriend(b);
        System.out.println(a.isDirectFriendOf(b));
        System.out.println(b.isDirectFriendOf(a));
        System.out.println(a.isDirectFriendOf(c));
        b.befriend(c);
        System.out.println(a.isDirectFriendOf(c));
        System.out.println(a.isIndirectFriendOf(c));
        System.out.println(b.isDirectFriendOf(c));
    }
}
