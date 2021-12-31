import java.util.Arrays;

public class makeshiftArrayListImpl implements makeshiftArrayList{

    private String[] array = new String[10];
    int size = 0;

    @Override
    public String get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(String string) {
        if(size >= array.length){
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = string;
        size++;
    }

    @Override
    public void add(String string, int index) {

    }

    @Override
    public boolean remove(String string) {
        for (int i = 0; i < size; i++){
            if(array[i].equals(string)){
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++){
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
        array = new String[10];
        size = 0;
    }

    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }
}
