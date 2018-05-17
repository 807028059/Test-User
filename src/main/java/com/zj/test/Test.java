package com.zj.test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        //有序  可重复
        List l = new ArrayList();
        l.add(1);
        l.add(4);
        l.add(3);
        l.add(1,4);
        System.out.println("l--------->"+l);
        //System.out.println("l--------->"+l.toArray());
        Iterator it = l.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //无序  不可重复
        Set s = new HashSet();
        s.add(1);
        s.add(3);
        s.add(2);
        s.add(3333);
        s.add(1);
        s.add(6);
        System.out.println("s--------->"+s);


    }
}
