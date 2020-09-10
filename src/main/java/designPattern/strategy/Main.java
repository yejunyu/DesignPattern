package designPattern.strategy;

/**
 * @author: yejunyu
 * date: 2018/9/6
 */
public class Main {
    /**
     * 我们假设你希望验证输入的内容是否根据标准进行了恰当的格式化(比如只包含小写字母或
     * 数字)。你可以从定义一个验证文本(以String的形式表示)的接口入手
     */
    public interface ValidationStrategy {
        boolean execute(String s);
    }

    public static class IsAllLowerCase implements ValidationStrategy {
        @Override
        public boolean execute(String s) {
            return s.matches("[a-z]+");
        }
    }

    public static class IsNumeric implements ValidationStrategy {
        @Override
        public boolean execute(String s) {
            return s.matches("\\d+");
        }
    }

    /**
     * 你就可以在程序中使用这些略有差异的验证策略了
     */
    public static class Validator {
        private final ValidationStrategy strategy;

        public Validator(ValidationStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean validate(String s) {
            return strategy.execute(s);
        }
    }

    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");

        // 使用 lambda 表达式
        Validator numericValidator1 =
                new Validator((String s) -> s.matches("[a-z]+"));
        boolean c1 = numericValidator1.validate("aaaa");
        Validator lowerCaseValidator1 =
                new Validator((String s) -> s.matches("\\d+"));
        boolean c2 = lowerCaseValidator1.validate("bbbb");
    }
}
