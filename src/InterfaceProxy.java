import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterfaceProxy implements InvocationHandler {
    Object target;

    public InterfaceProxy(Object object) {
        target = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy begins");
        Object result = method.invoke(target, args);
        System.out.println("Proxy ends");
        return result;
    }

    public Object newInstance(Object o) {
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), this);
    }
}
