package chainOfResponsibility.msgFilter;

/**
 * author: yejunyu
 * date: 2018/8/20
 */
public class FaceFilter implements Filter {
    @Override
    public String dofilter(String rawStr) {
        return rawStr.replace("~", ":)");
    }
}
