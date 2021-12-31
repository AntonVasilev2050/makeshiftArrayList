import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class makeshiftArrayListTest {

    private makeshiftArrayList makeshiftArrayList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // init
        for (int i = 0; i < 100; i++) {
            makeshiftArrayList.add("string-" + i);
        }
    }

    @Test
    public void whenAdded100StringsThenSizeMustBe100() {
        assertEquals(100, makeshiftArrayList.size());
    }

    @Test
    public void whenStringRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(makeshiftArrayList.removeAt(5));
        assertEquals(99, makeshiftArrayList.size());
    }

    @Test
    public void whenStringRemovedThenSizeMustBeDecreased(){
        String stringForTest = "testString";
        makeshiftArrayList.add(stringForTest);
        assertEquals(101, makeshiftArrayList.size());
        assertTrue(makeshiftArrayList.remove(stringForTest));
        assertEquals(100, makeshiftArrayList.size());
    }

    @Test
    public void whenNonExistentStringRemovedThenReturnFalse(){
        String stringForTest = "testString";
        assertFalse(makeshiftArrayList.remove(stringForTest));
        assertEquals(100, makeshiftArrayList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBeZero(){
        makeshiftArrayList.clear();
        assertEquals(0, makeshiftArrayList.size());
    }

//    @Test(expected = IndexOutOfBoundsException.class)
//    public void whenIndexOutOfBoundsThenThrowException(){
//        makeshiftArrayList.get(100);
//    }

    @Test
    public void whenIndexOutOfBoundsThenThrowException() {
        assertThrows(IndexOutOfBoundsException.class,
                ()->{
                    makeshiftArrayList.get(100);
                });
    }
}