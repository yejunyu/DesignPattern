package doYouKnow.lesson2.abtractContainer;

/**
 * @Author yjy
 * @Date 2023/3/24
 * 基于container3 的通用连接版本
 **/
public class UnionFindNode<V, S> implements ContainerLike<V, UnionFindNode<V, S>> {

    private UnionFindNode<V, S> parent = this;
    private int groupSize = 1;
    private final Attribute<V, S> attribute;
    private S summary;


    public UnionFindNode(Attribute<V, S> dom) {
        attribute = dom;
        summary = dom.seed();
    }

    public UnionFindNode<V, S> findRootAndCompress() {
        if (parent != this) {
            parent = parent.findRootAndCompress();
        }
        return parent;
    }


    @Override
    public V get() {
        UnionFindNode<V, S> root = findRootAndCompress();
        return attribute.report(root.summary);
    }

    @Override
    public void update(V val) {
        UnionFindNode<V, S> root = findRootAndCompress();
        attribute.update(root.summary, val);
    }

    @Override
    public void connectTo(UnionFindNode<V, S> other) {
        UnionFindNode<V, S> root1 = findRootAndCompress();
        UnionFindNode<V, S> root2 = other.findRootAndCompress();
        if (root1 == root2) {
            return;
        }
        int size1 = root1.groupSize, size2 = root2.groupSize;
        // 合并
        S newSummary = attribute.merge(root1.summary, root2.summary);
        // 按节点大小连接
        if (size1 <= size2) {
            root1.parent = root2;
            root2.summary = newSummary;
            root2.groupSize += size1;
        } else {
            root2.parent = root1;
            root1.summary = newSummary;
            root1.groupSize += size2;
        }
    }


}
