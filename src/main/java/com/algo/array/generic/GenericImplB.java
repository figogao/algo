package com.algo.array.generic;

public class GenericImplB implements Generic<String> {


    @Override
    public String next(String t) {
        return t;
    }

    public static void main(String [] args) {
        GenericImplB g = new GenericImplB ();

        System.out.println(g.next("abc"));
    }
}
