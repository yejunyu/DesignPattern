package factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author: yejunyu
 * date: 2018/9/7
 */
public class ProductFactory {
    public static Product createProduct(String name) {
        switch (name) {
            case "loan":
                return new Product.Loan();
            case "stock":
                return new Product.Stock();
            case "bond":
                return new Product.Bond();
            default:
                throw new RuntimeException("No such product " + name);
        }
    }

    /**
     * lambda 简化工厂
     */
    final static Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Product.Loan::new);
        map.put("stock", Product.Stock::new);
        map.put("bond", Product.Bond::new);
    }

    public static Product createProduct1(String name) {
        Supplier<Product> p = map.get(name);
        if (p != null) {
            return p.get();
        }
        throw new RuntimeException("No such product " + name);
    }

    public static void main(String[] args) {
        Product p = ProductFactory.createProduct("loan");

        /**
         * lambda 简化
         */
        Supplier<Product> loanSupplier = Product.Loan::new;
        Product.Loan loan = (Product.Loan) loanSupplier.get();
    }
}
