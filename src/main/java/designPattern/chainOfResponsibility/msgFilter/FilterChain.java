package designPattern.chainOfResponsibility.msgFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤链
 * 实现 Filter 接口,把整个 Chain 当做一个 Filter,之后就可以直接一个 Chain add 另一个 Chain
 * <p>
 * author: yejunyu
 * date: 2018/8/20
 */
public class FilterChain implements Filter {

    List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter f) {
        this.filters.add(f);
        return this;
    }


    @Override
    public String dofilter(String rawStr) {
        String r = rawStr;
        for (Filter filter : filters) {
            r = filter.dofilter(r);
        }
        return r;
    }
}
