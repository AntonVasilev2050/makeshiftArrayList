import java.util.Arrays;
import java.util.Comparator;

public class MakeshiftArrayListImpl<E> implements MakeshiftList<E> {

    private E[] array;
    int size = 0;

    public MakeshiftArrayListImpl() {
    }

    /**
     * Создает коллекцию с заданным начальным размером
     * @param initCapacity размер коллекции при инициализации
     *
     * @throws IllegalArgumentException будет выброшено,
     * при попытки инициализировать коллекцию размером меньше 1.
     */
    public MakeshiftArrayListImpl(int initCapacity) {
        if (initCapacity < 1){
            throw new IllegalArgumentException(
                    "Попытка инициализировать коллекцию с начальным размером меньше единицы");
        }
        this.array =  (E[]) new Object[initCapacity];
    }

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
    public void set(E e, int index) {
        checkIndex(index);
        array[index] = e;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkArrayLengthAndIncreaseArray() {
        if (array == null) {
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
