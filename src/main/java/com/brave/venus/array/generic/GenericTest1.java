package com.brave.venus.array.generic;

public class GenericTest1<T> {

    private T key;

    public GenericTest1(T key) {

        this.key = key;
    }

    public void setKey(T key) {

        this.key = key;
    }

    public T getKey() {

        return key;
    }

    public T addKey(T key, T value){
        return value;
    }

    public void showKeyValue1(GenericTest1<?> obj){
        System.out.println(obj.getKey());
    }

    public static void main(String [] agrs) {

        GenericTest1<Integer> g = new GenericTest1<>(12);
        Integer b = g.getKey();
        System.out.println(b);


        GenericTest1<Number> g1 = new GenericTest1<>(10);
        g1.showKeyValue1(g1);
        g1.showKeyValue1(g);
    }
}
