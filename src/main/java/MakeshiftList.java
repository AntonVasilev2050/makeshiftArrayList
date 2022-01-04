import java.util.Comparator;
import java.util.List;

/**
 * Самодельный List. Основные методы в учебных целях.
 *
 * @param <E> обобщенный тип
 * @author Anton Vasilev
 * @version 1.0
 */
public interface MakeshiftList<E> {
    /**
     * Получение элемента по индексу
     *
     * @param index индекс элемента
     * @return возвращает элемент из MakeshiftArrayList по индексу
     * @throws IndexOutOfBoundsException если элемента с таким index не существует.
     */
    E get(int index);

    /**
     * Добавление элемента в конец коллекции
     *
     * @param e добавляемый в коллекцию элемент
     */
    void add(E e);

    /**
     * Добавление элемента в коллекцию в позицию index
     *
     * @param e     добавляемый в коллекцию элемент
     * @param index индекс элемента
     */
    void add(E e, int index);

    /**
     * Удаление элемента из коллекции
     *
     * @param e удаляемый элемент
     * @return вернет true если удаление прошло успешно,
     * и false если элемент не был найден
     */
    boolean remove(E e);

    /**
     * Удаление элемента по заданному индексу
     *
     * @param index индекс удаляемого элемента
     * @return вернет true если удаление прошло успешно
     * @throws IndexOutOfBoundsException если элемента с таким index не существует.
     */
    boolean removeAt(int index);

    /**
     * Размер коллекции
     *
     * @return текущий размер коллекции
     */
    int size();

    /**
     * Удаление всех элементов из коллекции
     */
    void clear();

    /**
     * Установка элемента по заданному индексу
     *
     * @param e     устанавливаемый элемент
     * @param index индекс элемента который будет установлен
     */
    void set(E e, int index);

}
