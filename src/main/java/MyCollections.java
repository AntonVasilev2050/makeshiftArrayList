import java.util.Comparator;

public class MyCollections<E> {

    public static <E> void sort(MakeshiftList<E> makeshiftList, Comparator<E> comparator) {
        int low = 0;
        int high = makeshiftList.size() - 1;

        quickSortTwo(makeshiftList, low, high, comparator);
    }

    private static <E> void quickSortTwo(
            MakeshiftList<E> array,
            int leftBorder,
            int rightBorder,
            Comparator<E> comparator) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        E pivot = array.get((leftMarker + rightMarker) / 2);
        do {
            while (comparator.compare(array.get(leftMarker), pivot) < 0) {
                leftMarker++;
            }
            while (comparator.compare(array.get(rightMarker), pivot) > 0) {
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
            quickSortTwo(array, leftMarker, rightBorder, comparator);
        }
        if (leftBorder < rightMarker) {
            quickSortTwo(array, leftBorder, rightMarker, comparator);
        }
    }

    private static <E> void quickSort(MakeshiftList<E> array, int low, int high, Comparator<E> comparator) {
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
            while (comparator.compare(array.get(i), opora) < 0) {
                i++;
            }
            while (comparator.compare(array.get(j), opora) > 0) {
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
}
