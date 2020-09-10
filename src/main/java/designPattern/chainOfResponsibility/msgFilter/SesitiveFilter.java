package designPattern.chainOfResponsibility.msgFilter;

/**
 * author: yejunyu
 * date: 2018/8/20
 */
public class SesitiveFilter implements Filter {
    @Override
    public String dofilter(String rawStr) {
        return rawStr.replace("敏感", "***").replace("x", "*");
    }
}
