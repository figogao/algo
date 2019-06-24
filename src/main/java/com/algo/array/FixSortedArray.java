package com.algo.array;

/**
 * 实现一个大小固定的有序数组，支持动态增删改操作
 * 泛型化
 *
 * 问题：使用"T extends Comparable<T>"泛型后，测试用例不能指定具体类型，会抛出异常。
 * @param <T>
 */
public class FixSortedArray<T extends Comparable<T>> {

    public T[] array;

    private int size;

    public FixSortedArray(int capity){
        this.array = (T[]) new Comparable[capity];
    }

    /**
     * insert & sort
     * @param t
     */
    public void add(T t){
            if (size == 0) {
                this.array[0] = t;
                size ++;

                return;
            }

            if (t.compareTo(array[size - 1]) >= 0) {
                this.array[size] = t;

                if (size < array.length){

                    size ++;
                }

                return;
            }


            for (int i = 0 ; i < size; i++) {
                if (t.compareTo(array[i]) < 0) {
                    for (int j = size - 1; j >= i; j--){
                        if (size == array.length && j > 0){
                            array[j] = array[j - 1];;
                        } else {
                            array[j + 1] = array[j];
                        }
                    }

                    this.array[i] = t;

                    if (size < array.length){

                        size ++;
                    }

                    return;
                }
            }
    }

    public T get(Integer index){
        return array[index - 1];
    }

    public void remove(Integer index){
        if (size <= 0 || index > size - 1) {
            return;
        }

        //remove last element
        if (index.equals(size - 1)) {
            this.array[index] = null;
        }

        for (Integer i = index; i <= size - 1; i++) {
            //remove last element
            if (i.equals(size - 1)) {
                this.array[i] = null;
                break;
            }

            array[i] = array[i + 1];
        }

        size--;
    }

    public void update(Integer index, T t){
        if (size <= 0 || index > size - 1) {
            return;
        }

        // update last element
        remove(index);

        add(t);
    }



    public static void main(String [] args) {
        FixSortedArray array = new FixSortedArray(5);
        array.add(new Integer(12));
        array.add(new Integer(5));
        array.add(new Integer(7));
        array.add(new Integer(5));
        array.add(new Integer(2));
        array.add(new Integer(-2));
        array.add(new Integer(-1));

        /*array.remove(0);
            array.remove(4);
            array.remove(3);
            array.remove(1);
        */

        array.update(2, -3);
        for (int i = 0; i < array.size; i++) {
            System.out.println(array.array[i]);
        }

    }

}
