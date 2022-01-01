import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeshiftArrayListTest {

    private MakeshiftArrayList<String> makeshiftArrayList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        makeshiftArrayList = new MakeshiftArrayListImpl<String>();
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
        String stringForTest = "Test String";
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

    @Test
    public void methodGetReturnedRightValue(){
        assertEquals("string-3", makeshiftArrayList.get(3));
    }

    @Test
    public void insertIntoMiddle(){
        String stringForTest = "Test String";
        makeshiftArrayList.add(stringForTest, 50);
        String stringFromList = makeshiftArrayList.get(50);
        assertEquals("Test String", stringFromList);
    }

    @Test
    public void insertIntoFirstPosition(){
        String stringForTest = "Test String";
        makeshiftArrayList.add(stringForTest, 0);
        String stringFromList = makeshiftArrayList.get(0);
        assertEquals("Test String", stringFromList);
    }

    @Test
    public void insertIntoLastPosition(){
        String stringForTest = "Test String";
        makeshiftArrayList.add(stringForTest, 100);
        String stringFromList = makeshiftArrayList.get(100);
        assertEquals("Test String", stringFromList);
    }
}