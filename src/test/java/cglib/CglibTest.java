package cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yaojiafeng
 * @create 2017-10-10 下午12:35
 */
public class CglibTest {

    @Test
    public void testCglibProxy() {
        CglibProxy cp = new CglibProxy();
        UserService proxy = (UserService) cp.getProxy(UserServiceImpl.class);
        proxy.add();
    }


    /**
     * 拦截类
     */
    public class CglibProxy implements MethodInterceptor {

        private Enhancer enhancer = new Enhancer();

        public Object getProxy(Class clazz) {
            enhancer.setSuperclass(clazz);
            enhancer.setCallback(this);
            return enhancer.create();
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            Object result = proxy.invokeSuper(obj, args);
//            Object result = method.invoke(obj, args);//死循环
//            Object result = proxy.invoke(obj, args);//死循环
//这里可以类似spring aop直接反射调用被代理的类的方法
            return result;
        }
    }


}
