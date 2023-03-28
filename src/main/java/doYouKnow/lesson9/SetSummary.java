package doYouKnow.lesson9;

import doYouKnow.lesson8.Attribute;
import doYouKnow.lesson8.UnionFindNode;

import java.util.*;
import java.util.function.BiPredicate;

/**
 * @Author yjy
 * @Date 2023/3/28
 **/
public class SetSummary<T> {
    public static <T> Set<Set<T>> partition(Collection<? extends T> collection, BiPredicate<? super T, ? super T> equivalent) {
        Attribute<Set<T>, Set<T>> group = Attribute.of(
                HashSet::new,
                Set::addAll,
                (s1, s2) -> {
                    Set<T> u = new HashSet<>(s1);
                    u.addAll(s2);
                    return u;
                },
                s -> s
        );
        Map<T, UnionFindNode<Set<T>, Set<T>>> nodeMap = new HashMap<>();
        for (T t : collection) {
            UnionFindNode<Set<T>, Set<T>> node = new UnionFindNode<>(group);
            node.update(Set.of(t));
            nodeMap.put(t, node);
        }
        for (T t1 : collection) {
            for (T t2 : collection) {
                if (equivalent.test(t1, t2)) {
                    nodeMap.get(t1).connectTo(nodeMap.get(t2));
                }
            }
        }
        Set<Set<T>> result = new HashSet<>();
        for (T t : collection) {
            result.add(nodeMap.get(t).get());
        }
        return result;
    }

    public static void main(String[] args) {
        BiPredicate<String, String> sameLength = (a, b) -> a.length() == b.length();
        Set<String> names = Set.of("Walter", "Skyler", "Hank", "Mike", "Saul");
        Set<Set<String>> groups = partition(names, sameLength);
        System.out.println(groups);
    }
}
