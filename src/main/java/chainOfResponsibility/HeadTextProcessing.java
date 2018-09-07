package chainOfResponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author: yejunyu
 * date: 2018/9/7
 */
public class HeadTextProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return "From raoul,Mario and Alan: " + input;
    }

    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeadTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckProcessing();
        p1.setSuccessor(p2);
        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);

        /**
         * lambda 简化
         */
        UnaryOperator<String> headerProcessing = (String text) -> "From raoul,Mario and Alan: " + text;
        UnaryOperator<String> spellCheckProcessing = (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline =
                headerProcessing.andThen(spellCheckProcessing);
        String result1 = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result1);
    }
}
