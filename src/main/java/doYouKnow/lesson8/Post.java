package doYouKnow.lesson8;

/**
 * 通用的计算点赞框架
 *
 * @Author yjy
 * @Date 2023/3/27
 **/
public class Post extends UnionFindNode<Integer, PostSummary> {
    public Post() {
        super(PostSummary.ops);
    }
}
