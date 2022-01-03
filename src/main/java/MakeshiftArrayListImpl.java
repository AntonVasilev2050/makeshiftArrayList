import java.util.Arrays;
import java.util.Collections;

public class MakeshiftArrayListImpl<E> implements MakeshiftList<E>{

    private E[] array;
    int size = 0;

    @Override
    public E get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(E e) {
        checkArrayLengthAndIncreaseArray();
        array[size] = e;
        size++;
    }

    @Override
    public void add(E e, int index) {
        checkArrayLengthAndIncreaseArray();
        if (size - index >= 0) System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = e;
        size++;
    }

    @Override
    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        if (size - 1 - index >= 0) System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = (E[]) new Object[10];
        size = 0;
    }

    @Override
    public MakeshiftList<E> sort(MakeshiftList<E> makeshiftList) {
        return null;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkArrayLengthAndIncreaseArray() {
        if(array == null){
            array = (E[]) new Object[10];
        }
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    @Override
    public String toString() {
        return "MakeshiftArrayListImpl{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
