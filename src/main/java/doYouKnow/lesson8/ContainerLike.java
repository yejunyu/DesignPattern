package doYouKnow.lesson8;

/**
 * @Author yjy
 * @Date 2023/3/24
 **/
public interface ContainerLike<V, T extends ContainerLike<V, T>> {

    V get();

    void update(V val);

    void connectTo(T other);
}
