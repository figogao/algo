package com.algo.array;

/**
 * 实现一个大小固定的有序数组，支持动态增删改操作
 * 泛型方法,进行强壮为T
 * 或者为泛型类，不需要声明为泛型方法
 *
 */
public class FixSortedArray2 {

    public Object[] array;

    private int size;

    public FixSortedArray2(int capity){
        this.array = new Object[capity];
    }

    /**
     * insert & sort
     * @param t
     */
    public <T extends Comparable<? super T>> void add(T t){
            if (size == 0) {
                this.array[0] = t;
                size ++;

                return;
            }

            if (t.compareTo((T)array[size - 1]) >= 0) {
                this.array[size] = t;

                if (size < array.length){

                    size ++;
                }

                return;
            }


            for (int i = 0 ; i < size; i++) {
                if (t.compareTo((T)array[i]) < 0) {
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

    public <T extends Comparable<? super T>> T get(Integer index){
        return (T)array[index - 1];
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

    public <T extends Comparable<? super T>> void update(Integer index, T t){
        if (size <= 0 || index > size - 1) {
            return;
        }

        // update last element
        remove(index);

        add(t);
    }



    public static void main(String [] args) {
        FixSortedArray2 array = new FixSortedArray2(5);
        array.add(12);
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
