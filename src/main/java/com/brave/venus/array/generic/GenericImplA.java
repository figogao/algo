package com.brave.venus.array.generic;

public class GenericImplA<T> implements Generic<T> {


    @Override
    public T next(T t) {
        return t;
    }

    public static void main(String [] args) {
        GenericImplA<Integer> g = new GenericImplA<>();

        System.out.println(g.next(2));
    }
}
