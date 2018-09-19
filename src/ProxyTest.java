import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        InterfaceIMP obj = new InterfaceIMP();
        InterfaceProxy pro = new InterfaceProxy(obj);
        GoodBye iner = (GoodBye) pro.newInstance(obj);
        //iner.sayHello("fovercome");
        iner.sayGoodBye("fovercome");
        return;

    }
}
