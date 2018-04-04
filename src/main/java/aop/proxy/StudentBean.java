package main.java.aop.proxy;

/**
 * @author yejunyu
 * @date 2018/4/4.
 */
public class StudentBean implements IStudent{

    private String name;

    public StudentBean() {
    }

    public StudentBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("hello");
    }
}
