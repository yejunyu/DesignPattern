package main.java.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yejunyu
 * @date 2018/4/4.
 */
public class ProxyFactory implements InvocationHandler{

    private Object student;

    public Object createStudentProxy(Object student){
        this.student = student;
        return Proxy.newProxyInstance(student.getClass().getClassLoader(),student.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StudentBean s = (StudentBean) student;
        Object object = null;
        if (s.getName() != null){
            object = method.invoke(student, args);
        } else {
            System.out.println("名称为空,代理类已经进行拦截!");
        }
        return student;
    }
}
