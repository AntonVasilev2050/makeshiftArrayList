import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class makeshiftArrayListTest {

    private makeshiftArrayList makeshiftArrayList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // init
    }

    @Test
    public void whenAdded100StringsThenSizeMustBe100(){
       for (int i = 0; i < 100; i++){
           makeshiftArrayList.add("string-" + i);
       }
       assertEquals(100, makeshiftArrayList.size());
    }

    @Test
    public void whenStringRemovedByIndexThenSizeMustBeDecreased(){
        for (int i = 0; i < 100; i++){
            makeshiftArrayList.add("string-" + i);
        }
        assertEquals(100, makeshiftArrayList.size());
        assertTrue(makeshiftArrayList.removeAt(5));
        assertEquals(99, makeshiftArrayList.size());
    }
}