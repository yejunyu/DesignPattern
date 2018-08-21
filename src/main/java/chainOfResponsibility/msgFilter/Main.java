package chainOfResponsibility.msgFilter;

/**
 * author: yejunyu
 * date: 2018/8/20
 */
public class Main {

    /**
     * Main -> FilterChain -> Filter
     * 单向的过滤链
     *
     * @param args
     */
    public static void main(String[] args) {
        String rawStr = "我是一段敏感的字符串<script>,XXX~";

        // 创建过滤链
        FilterChain fc = new FilterChain();
        fc.addFilter(new HTMLFilter())
                .addFilter(new SesitiveFilter());
        FilterChain fc2 = new FilterChain();
        fc2.addFilter(new FaceFilter());
        fc.addFilter(fc2);

        String afterStr = fc.dofilter(rawStr);
        System.out.println(afterStr);
    }
}
