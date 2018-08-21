package chainOfResponsibility.responseFilter;

import java.util.function.Supplier;

/**
 * 正常的服务器应该是 client 发给server 的 request 过滤一遍
 * server 返回给 client 的 response 也得过滤
 * author: yejunyu
 * date: 2018/8/21
 */
public class Main {
    public static void main(String[] args) {
        // 构造方法引用创建对象,没有别的用,只是试下函数式接口
        Supplier<Request> requestSupplier = Request::new;
        Supplier<Response> responseSupplier = Response::new;
        Request request = requestSupplier.get();
        Response response = responseSupplier.get();

        // 创建敏感字符串和 filterChain
        String rawStr = "我是一段敏感的字符串<script>,XXX~";
        request.setRequestStr(rawStr);
        response.setResponseStr("response");
        FilterChain fc = new FilterChain();
        fc.addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter());
        FilterChain fc1 = new FilterChain();
        fc1.addFilter(new FaceFilter());
        fc.addFilter(fc1);

        // doFilter
        fc.dofilter(request, response, fc);
        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());
    }
}
