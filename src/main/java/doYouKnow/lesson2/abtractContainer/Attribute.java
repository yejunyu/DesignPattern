package doYouKnow.lesson2.abtractContainer;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author yjy
 * @Date 2023/3/24
 **/
public interface Attribute<V, S> {
    /**
     * 提供初始的摘要
     * 类似于水容器的构造函数
     *
     * @return
     */
    S seed();

    /**
     * 用一个值更新一个摘要
     * 类似于水容器的update
     *
     * @param summary
     * @param value
     */
    void update(S summary, V value);

    /**
     * 合并两个摘要
     * 类似于水容器的connectTo
     *
     * @param summary1
     * @param summary2
     * @return
     */
    S merge(S summary1, S summary2);

    /**
     * 解包一个摘要得到值
     * 类似于水容器的getAmount
     *
     * @param summary
     * @return
     */
    V report(S summary);

    static <V, S> Attribute<V, S> of(
            Supplier<S> supplier,
            BiConsumer<S, V> updater,
            BinaryOperator<S> combiner,
            Function<S, V> finisher
    ) {
        return new Attribute<V, S>() {
            @Override
            public S seed() {
                return supplier.get();
            }

            @Override
            public void update(S summary, V value) {
                updater.accept(summary, value);
            }

            @Override
            public S merge(S summary1, S summary2) {
                return combiner.apply(summary1, summary2);
            }

            @Override
            public V report(S summary) {
                return finisher.apply(summary);
            }
        };
    }
}
