package com.singleTon;

public class q1c {

    public static final q1c INSTANCE;

    static {
        INSTANCE = new q1c();
    }
    private q1c(){

    }
}
