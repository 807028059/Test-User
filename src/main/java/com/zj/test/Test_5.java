package com.zj.test;

public class Test_5 {
    public static int a = 1;
    public static final int b = 1;
    public static void t(){
        a++;
    }
    public static void s(){
        System.out.println("s-------->"+a);
    }
    public static void main(String[] args){
        a++;
        s();
        t();
        System.out.print(a);
    }
}
