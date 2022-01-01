public interface MakeshiftArrayList<E> {
    E get (int index);
    void add(E e);
    void add(E e, int index);
    boolean remove(E e);
    boolean removeAt(int index);
    int size();
    void clear();

}
