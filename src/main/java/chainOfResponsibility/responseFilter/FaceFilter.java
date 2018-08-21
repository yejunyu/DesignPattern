package chainOfResponsibility.responseFilter;

/**
 * author: yejunyu
 * date: 2018/8/20
 */
public class FaceFilter implements Filter {

    @Override
    public void dofilter(Request request, Response response, FilterChain filterChain) {
        request.requestStr = request.requestStr.replace("~", ":)") + " ~FaceFilter ";
        filterChain.dofilter(request, response, filterChain);
        response.responseStr += " ~FaceFilter ";
    }
}
