package aop.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yejunyu
 * @date 2018/4/4.
 */
public class CGLibProxyFactory implements org.springframework.cglib.proxy.MethodInterceptor{

    private Object object;

    public Object createaStudent(Object object){
        this.object = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback((Callback) this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        StudentBean stu = objects;
   }
}
