public class InterfaceIMP implements Hello, GoodBye {
    @Override
    public void sayGoodBye(String s) {
        System.out.println(s + ", good bye!");
    }

    @Override
    public void sayHello(String s) {
        System.out.println(s + ", hello!");

    }
}
