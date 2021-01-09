package com.singleTon;

public class q2test {
    public static void main(String[] args) {
        //first Method
        q2 s1 = q2.INSTANCE;
        System.out.println(s1);

        q2b s2 = q2b.INSTANCE;
        System.out.println(s2);
    }
}
