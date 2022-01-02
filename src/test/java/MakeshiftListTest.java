import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для интерфейса MakeshiftList
 */
class MakeshiftListTest {

    /**
     * Создаем ссылку на испытуемый объект
     */
    private MakeshiftList<String> makeshiftArrayList;


    /**
     * Перед каждым тестом создаем makeshiftArrayList
     * и добавляем в него 100 строк
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        makeshiftArrayList = new MakeshiftArrayListImpl<>();
        for (int i = 0; i < 100; i++) {
            makeshiftArrayList.add("string-" + i);
        }
    }

    /**
     * Проверяем что размер коллекции стал равен 100
     */
    @Test
    public void whenAdded100StringsThenSizeMustBe100() {
        assertEquals(100, makeshiftArrayList.size());
    }

    /**
     * Проверяем, что если была удалена одна строка с заданным индексом,
     * то размер коллекции уменьшился на единицу
     */
    @Test
    public void whenStringRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(makeshiftArrayList.removeAt(5));
        assertEquals(99, makeshiftArrayList.size());
    }

    /**
     * Проверяем, что удаление тестовой строки возвращает true,
     * и после удаления строки размер коллекции уменьшается на единицу
     */
    @Test
    public void whenStringRemovedThenSizeMustBeDecreased(){
        String stringForTest = "testString";
        makeshiftArrayList.add(stringForTest);
        assertEquals(101, makeshiftArrayList.size());
        assertTrue(makeshiftArrayList.remove(stringForTest));
        assertEquals(100, makeshiftArrayList.size());
    }

    /**
     * Проверяем, что при попытке удаления не существующей строки,
     * будет возвращен false и размер коллекции не изменится
     */
    @Test
    public void whenNonExistentStringRemovedThenReturnFalse(){
        String stringForTest = "Test String";
        assertFalse(makeshiftArrayList.remove(stringForTest));
        assertEquals(100, makeshiftArrayList.size());
    }

    /**
     * Проверяем, что после очистки коллекции ее размер
     * становится равным 0
     */
    @Test
    public void whenListClearedThenSizeMustBeZero(){
        makeshiftArrayList.clear();
        assertEquals(0, makeshiftArrayList.size());
    }

//    @Test(expected = IndexOutOfBoundsException.class)
//    public void whenIndexOutOfBoundsThenThrowException(){
//        makeshiftArrayList.get(100);
//    }

    /**
     * Проверяем, что при попытки получить элемент с несуществующим индексом,
     * выбрасывается исключение IndexOutOfBoundsException
     */
    @Test
    public void whenIndexOutOfBoundsThenThrowException() {
        assertThrows(IndexOutOfBoundsException.class,
                ()->{
                    makeshiftArrayList.get(100);
                });
    }

    /**
     * Проверяем, что метод get возвращает ожидаемое значение
     */
    @Test
    public void methodGetReturnedRightValue(){
        assertEquals("string-3", makeshiftArrayList.get(3));
    }

    /**
     * Проверяем вставку по индексу в середину коллекции
     */
    @Test
    public void insertIntoMiddle(){
        String stringForTest = "Test String";
        makeshiftArrayList.add(stringForTest, 50);
        String stringFromList = makeshiftArrayList.get(50);
        assertEquals("Test String", stringFromList);
    }

    /**
     * Проверяем вставку по индексу в первую позицию коллекции
     */
    @Test
    public void insertIntoFirstPosition(){
        String stringForTest = "Test String";
        makeshiftArrayList.add(stringForTest, 0);
        String stringFromList = makeshiftArrayList.get(0);
        assertEquals("Test String", stringFromList);
    }

    /**
     * Проверяем вставку по индексу в последнюю позицию коллекции
     */
    @Test
    public void insertIntoLastPosition(){
        String stringForTest = "Test String";
        makeshiftArrayList.add(stringForTest, 100);
        String stringFromList = makeshiftArrayList.get(100);
        assertEquals("Test String", stringFromList);
    }
}