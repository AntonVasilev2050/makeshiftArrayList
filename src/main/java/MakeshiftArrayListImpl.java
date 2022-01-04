import java.util.Arrays;
import java.util.Comparator;

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
    public void set(E e, int index) {
        checkIndex(index);
        array[index] = e;
    }

    @Override
    public void sort(MakeshiftList<E> makeshiftList, Comparator<E> comparator) {
        int low = 0;
        int high = makeshiftList.size() - 1;

        quickSortTwo(makeshiftList, low, high, comparator);
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


    public void quickSort(MakeshiftList<E> array, int low, int high, Comparator<E> comparator) {
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
            while (comparator.compare(array.get(i), opora) == -1){
                i++;
            }
            while (comparator.compare(array.get(j), opora) == 1){
                j--;
            }

            if (i <= j) {//меняем местами
                E temp = array.get(i);
                array.set(array.get(j), i);
                array.set(temp, j);
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j, comparator);

        if (high > i)
            quickSort(array, i, high, comparator);
    }

    public void quickSortTwo(MakeshiftList<E> array, int leftBorder, int rightBorder, Comparator<E> comparator) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        E pivot = (array.get((leftMarker + rightMarker) / 2));
        do {
            while (comparator.compare(array.get(leftMarker), pivot) == -1){
                leftMarker++;
            }
            while (comparator.compare(array.get(rightMarker), pivot) == 1){
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    E tmp = array.get(leftMarker);
                    array.set(array.get(rightMarker), leftMarker);
                    array.set(tmp, rightMarker);
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(array, leftMarker, rightBorder, comparator);
        }
        if (leftBorder < rightMarker) {
            quickSort(array, leftBorder, rightMarker, comparator);
        }
    }

    @Override
    public String toString() {
        return "MakeshiftArrayListImpl{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
