import java.util.Arrays;

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
    public void sort(MakeshiftList<E> makeshiftList) {
        int low = 0;
        int high = makeshiftList.size() - 1;

        quickSort(makeshiftList, low, high);
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

    public void quickSort(MakeshiftList<E> array, int low, int high) {
        if (array.size() == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        E opora = array.get(middle);

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array.get(i) < opora) {
                i++;
            }

            while (array.get(j) > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array.get(i);
                array.get(i) = array.get(j);
                array.get(j) = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    @Override
    public String toString() {
        return "MakeshiftArrayListImpl{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
