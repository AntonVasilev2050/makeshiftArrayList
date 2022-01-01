import java.util.Arrays;

public class MakeshiftArrayListImpl<E> implements MakeshiftArrayList<E> {

    private E[] array;
    int size = 0;

    @Override
    public E get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(E e) {
        checkAndIncreaseArray();
        array[size] = e;
        size++;
    }

    @Override
    public void add(E e, int index) {
        checkAndIncreaseArray();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
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
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new E[10];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkAndIncreaseArray() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }
}
