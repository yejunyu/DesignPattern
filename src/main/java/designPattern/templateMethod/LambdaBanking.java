package designPattern.templateMethod;

import java.util.function.Consumer;

/**
 * @author: yejunyu
 * date: 2018/9/6
 */
public class LambdaBanking {
    public static void processCustomer(int id, Consumer<OnlineBanking.Customer> makeCustomerHappy) {
        OnlineBanking.Customer c = OnlineBanking.Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }

    public static void main(String[] args) {
        LambdaBanking.processCustomer(1337, (OnlineBanking.Customer c) -> System.out.println("Hello " + c));
    }
}
