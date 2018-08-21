package chainOfResponsibility.responseFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * author: yejunyu
 * date: 2018/8/21
 */
public class FilterChain implements Filter {

    List<Filter> filters = new ArrayList<>();

    int index = 0;

    public FilterChain addFilter(Filter f) {
        this.filters.add(f);
        return this;
    }

    @Override
    public void dofilter(Request request, Response response, FilterChain filterChain) {
        // FilterChain 的 index
        if (index >= filters.size()) {
            return;
        }
        Filter f = filters.get(index);
        index++;
        f.dofilter(request, response, filterChain);
    }
}
