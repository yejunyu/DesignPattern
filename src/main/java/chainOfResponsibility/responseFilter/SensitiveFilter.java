package chainOfResponsibility.responseFilter;

/**
 * author: yejunyu
 * date: 2018/8/20
 */
public class SensitiveFilter implements Filter {

    @Override
    public void dofilter(Request request, Response response, FilterChain filterChain) {
        request.requestStr = request.requestStr.replace("敏感", "***").replace("x", "*") + " ~SesitiveFilter ";
        filterChain.dofilter(request, response, filterChain);
        response.responseStr += " ~Sensitive ";
    }
}
