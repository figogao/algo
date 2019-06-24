package com.algo.array;

/**
 * 简单测试数组
 */
public class SimpleArray {
    private int index;
    private int[] oriItems;

    public SimpleArray(int count){
        oriItems = new int[count];
        this.index = 0;
    }
    public void add(int item){
        int length = this.oriItems.length;
        if (index > length-1) {
            oriItems = java.util.Arrays.copyOf(oriItems, oriItems.length * 2);
        }

        oriItems[index] = item;
        index ++;
    }
    public int[] get(){
        return oriItems;
    }
    public static void main(String[] args){
        SimpleArray arrays = new SimpleArray(3);
        int i = 0;
        while(i < 11){
            arrays.add(i);
            i++;
        }

        for (int item : arrays.get()){
            System.out.println(item);
        }
    }
}
