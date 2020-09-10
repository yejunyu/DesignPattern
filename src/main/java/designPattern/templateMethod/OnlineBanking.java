package designPattern.templateMethod;

/**
 * @author: yejunyu
 * date: 2018/9/6
 */
public abstract class OnlineBanking {
    static class Customer {
    }

    static class Database {
        static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }

    abstract void makeCustomerHappy(Customer c);

    // 通过模板包起来
    public void processCustomer(int id) {
        // 不变得部分
        Customer c = Database.getCustomerWithId(id);
        // 变得部分
        makeCustomerHappy(c);
    }
}
