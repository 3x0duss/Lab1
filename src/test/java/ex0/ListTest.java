package ex0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    //Добавление в пустой список
    @Test
    void pushBackInEmptyTest() {

        List<Integer> list = new List<>();

        list.pushBack(5);


        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals(5, list.find(0));

    }

    //Добавление в полный список
    @Test
    void pushBackInFullTest() {

        List<Integer> list = new List<>();

        list.pushBack(5);
        list.pushBack(10);
        list.pushBack(15);

        assertFalse(list.isEmpty());
        assertEquals(3, list.size());
        assertEquals(15, list.find(2));

    }

    //Добавление по индексу в пустой список
    @Test
    void addInEmptyTest() {

        List<Integer> list = new List<>();

        assertThrows(IndexOutOfBoundsException.class, () -> { list.add(5,5); });

    }

    //Добавление по индексу в полный список
    @Test
    void addInFullTest() {

        List<Integer> list = new List<>();

        list.pushBack(6);
        list.pushBack(12);
        list.pushBack(18);

        list.add(5,2);

        assertFalse(list.isEmpty());
        assertEquals(4, list.size());
        assertEquals(5, list.find(2));

    }

    //Добавление null значения по индексу в полный список
    @Test
    void addNullInFullTest() {

        List<Integer> list = new List<>();

        list.pushBack(6);
        list.pushBack(12);
        list.pushBack(18);

        assertThrows(NullPointerException.class, () -> { list.add(null,2); });

    }

    //Поиск по индексу в пустом списке
    @Test
    void FindInEmptyTest() {

        List<Integer> list = new List<>();

        assertThrows(IndexOutOfBoundsException.class, () -> { list.find(5); });

    }

    //Поиск по индексу в полном списке
    @Test
    void FindInFullTest() {

        List<Integer> list = new List<>();

        list.pushBack(6);
        list.pushBack(12);
        list.pushBack(18);

        assertEquals(12, list.find(1));

    }

    //Поиск по индексу за пределами в полном списке
    @Test
    void FindInFullOutTest() {

        List<Integer> list = new List<>();

        list.pushBack(6);
        list.pushBack(12);
        list.pushBack(18);

        assertThrows(IndexOutOfBoundsException.class, () -> { list.find(5); });

    }

    //Удаление по индексу в пустом списке
    @Test
    void RemoveInEmptyTest() {

        List<Integer> list = new List<>();

        assertThrows(IndexOutOfBoundsException.class, () -> { list.remove(1); });

    }

    //Удаление по индексу в полном списке
    @Test
    void RemoveInFullTest1() {

        List<Integer> list = new List<>();

        list.pushBack(6);
        list.pushBack(12);
        list.pushBack(18);

        int size = list.size();

        list.remove(0);

        assertEquals(12, list.find(0));
        assertEquals(size - 1, list.size());

    }

    //Удаление по индексу в полном списке
    @Test
    void RemoveInFullTest2() {

        List<Integer> list = new List<>();

        list.pushBack(6);
        list.pushBack(12);
        list.pushBack(18);

        int size = list.size();

        list.remove(1);

        assertEquals(18, list.find(1));
        assertEquals(size - 1, list.size());

    }

    //Удаление по индексу в полном списке
    @Test
    void RemoveInFullTest3() {

        List<Integer> list = new List<>();

        list.pushBack(6);
        list.pushBack(12);
        list.pushBack(18);

        int size = list.size();

        list.remove(2);

        assertEquals(12, list.find(list.size()-1));
        assertEquals(size - 1, list.size());

    }

    //Удаление по индексу за границами в полном списке
    @Test
    void RemoveInFullOutTest() {

        List<Integer> list = new List<>();

        list.pushBack(6);
        list.pushBack(12);
        list.pushBack(18);

        list.remove(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(2);
        });

    }

    //Проверка на пустоту
    @Test
    void IsEmptyInEmptyTest() {

        List<Integer> list = new List<>();

        assertTrue(list.isEmpty());
    }

    //Проверка на пустоту
    @Test
    void IsEmptyInFullTest() {

        List<Integer> list = new List<>();

        list.pushBack(6);
        list.pushBack(12);
        list.pushBack(18);

        assertFalse(list.isEmpty());
    }

    //Проверка на размер
    @Test
    void SizeInEmptyTest() {

        List<Integer> list = new List<>();

        assertEquals(0, list.size());
    }

    //Проверка на размер
    @Test
    void SizeInFullAfterAddTest() {

        List<Integer> list = new List<>();

        list.pushBack(6);
        list.pushBack(12);
        list.pushBack(18);

        int size = list.size();

        list.pushBack(24);

        assertEquals(size + 1, list.size());
    }

    //Проверка на размер
    @Test
    void SizeInFullAfterRemoveTest() {

        List<Integer> list = new List<>();

        list.pushBack(6);
        list.pushBack(12);
        list.pushBack(18);

        int size = list.size();

        list.remove(2);

        assertEquals(size + 1, list.size());
    }

    //Проверка  toString с пустым списком
    @Test
    void ToStringInEmptyTest() {
        List<Integer> list = new List<>();

        assertEquals("[  ]", list.toString());
    }

    //Проверка  toString с полным списком
    @Test
    void ToStringInFullTest() {
        List<Integer> list = new List<>();

        list.pushBack(6);
        list.pushBack(12);


        assertEquals("[ 6 - 12 ]", list.toString());
    }

    //Проверка удаления в пустом списке
    @Test
    void ClearInEmptyTest() {
        List<Integer> list = new List<>();

        int size = list.size();

        list.clear();

        assertEquals(size, list.size());
    }

    //Проверка удаления в полном списке
    @Test
    void ClearInFullTest() {
        List<Integer> list = new List<>();

        list.pushBack(6);
        list.pushBack(12);
        list.pushBack(18);


        int size = list.size();

        list.clear();

        assertEquals(size-3, list.size());
    }

}