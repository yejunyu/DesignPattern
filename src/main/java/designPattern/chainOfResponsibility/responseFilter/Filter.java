package designPattern.chainOfResponsibility.responseFilter;

/**
 * author: yejunyu
 * date: 2018/8/21
 */
public interface Filter {
    void dofilter(Request request, Response response, FilterChain filterChain);
}
