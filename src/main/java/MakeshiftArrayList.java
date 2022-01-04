public interface MakeshiftArrayList {
    String get (int index);
    void add(String string);
    void add(String string, int index);
    boolean remove(String string);
    boolean removeAt(int index);
    int size();
    void clear();

}
