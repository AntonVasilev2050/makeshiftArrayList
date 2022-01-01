import java.sql.Array;
import java.util.Arrays;

public class MakeshiftArrayListImpl implements MakeshiftArrayList {

//    private String[] array = new String[10];
    private String[] array;
    int size = 0;

    @Override
    public String get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(String string) {
        checkAndIncreaseArray();
        array[size] = string;
        size++;
    }

    @Override
    public void add(String string, int index) {
        checkAndIncreaseArray();
        if (size - index >= 0) System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = string;
        size++;
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
        array = new String[10];
        size = 0;
    }

    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkAndIncreaseArray(){
        if (array == null){
            array = new String[10];
        }
        if(size >= array.length){
            array = Arrays.copyOf(array, array.length * 2);
        }
    }
}
