package java8.function_test;

/**
 * @Author yjy
 * @Date 2023/5/19
 **/
public class VUtils {

    public static ThrowExceptionFunction isTrue(boolean b) {
        return (errMessage) -> {
            if (!b) {
                throw new RuntimeException(errMessage);
            }
        };
    }

    public static void main(String[] args) {
        VUtils.isTrue(false).throwMessage("抛出一个异常");
    }
}
