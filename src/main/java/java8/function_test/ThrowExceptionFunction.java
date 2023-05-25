package java8.function_test;

/**
 * @Author yjy
 * @Date 2023/5/19
 **/
@FunctionalInterface
public interface ThrowExceptionFunction {

    /**
     * 抛出异常
     */
    void throwMessage(String message);
}
