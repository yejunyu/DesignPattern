package chainOfResponsibility;

/**
 * @author: yejunyu
 * date: 2018/9/7
 */
public class SpellCheckProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return input.replaceAll("labda", "lambda");
    }
}
