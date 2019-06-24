package com.brave.venus.array;

/**
 * 实现一个支持动态扩容的数组
 * 泛型化实现方式
 * @author figo
 */
public class DynamicArray<T> {
    private int index;
    private T[] oriItems;

    @SuppressWarnings("unchecked")
    public DynamicArray(int count){
        oriItems = (T[])new Object[count];
        this.index = 0;
    }

    public void add(T item){
        int length = this.oriItems.length;
        if (index > length-1) {
            oriItems = java.util.Arrays.copyOf(oriItems, oriItems.length * 2);
        }

        oriItems[index] = item;
        index ++;
    }

    public T get(int index){
        return oriItems[index];
    }

    public static void main(String[] args){
        DynamicArray<Integer> arrays = new DynamicArray<>(3);
        int i = 0;
        while(i < 11){
            arrays.add(i);
            i++;
        }

        i = 0;
        while(i < 11){
            System.out.println(arrays.get(i));
            i++;
        }
    }
}
