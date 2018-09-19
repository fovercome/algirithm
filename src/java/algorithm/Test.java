//package java.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String>[] list = new ArrayList[2];
        list[1] = new ArrayList();
        list[0] = new ArrayList();
        list[1].add( "what");
        list[0].add("you");
        System.out.println(list[1]);
        System.out.println(list[0]);
    }



}
