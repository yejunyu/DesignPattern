package chainOfResponsibility.responseFilter;

/**
 * author: yejunyu
 * date: 2018/8/20
 */
public class HTMLFilter implements Filter {

    @Override
    public void dofilter(Request request, Response response, FilterChain filterChain) {
        request.requestStr = request.requestStr.replace("<", "[").replace(">", "]") + " ~HTMLFilter ";
        filterChain.dofilter(request, response, filterChain);
        response.responseStr += " ~HTMLFilter ";
    }
}
