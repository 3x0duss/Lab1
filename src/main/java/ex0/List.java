package ex0;

/**
 * Класс List - реализация односвязного списка и его методов
 *
 * @param <T> тип данных для работы с классом
 *
 * @author ex0
 */
public class List <T> {

    /**
     * Node - класс узлов, из которых состоит список
     */
    private static class Node <T> {
        private final T val;
        private Node<T> next;

        /**
         * Конструктор с параметром
         *
         * @param val данные, передаваемые в узел
         *            
         * @example <p>Пример использования конструктора:
         *      <pre>{@code
         *           List list = new List(5);
         *      }</pre>
         */
        private Node(T val) {
            this.val = val;
            next = null;
        }

        /**
         * Перегруженный метод toString класса Object
         *
         * @return возвращает информацию об узле
         *
         */
        @Override
        public String toString() {
            return val.toString();
        }
    }

    private Node<T> head;
    private int size;

    /**
     * Конструктор по умолчанию
     *
     * @example <p>Пример использования конструктора:
     *      <pre>{@code
     *           List list = new List();
     *      }</pre>
     */
    public List() {
        head = null;
        size = 0;
    }

    /**
     * Метод добавления элемента в конец списка
     *
     * @param val данные, передаваемые в узел
     *
     */
    public void pushBack(T val) {

        if (head == null) {
            head = new Node<>(val);

        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;

            }
            temp.next = new Node<>(val);
        }

        ++size;
    }

    /** Метод добавления элемента по индексу
     *
     * @param index индекс необходимого нам элемента
     * @param val даныне,передаваемые в узел
     *
     * @throws IndexOutOfBoundsException при выходе за границы списка
     * @throws NullPointerException при null значении
     */
    public void add(T val, int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        else if(val == null){
            throw new NullPointerException();
        }

        Node<T> temp = head;
        int i = 0;

        while (i != index-1) {
            temp = temp.next;
            ++i;

        }

        Node<T> tempNext = temp.next;
        Node<T> tempNew = new Node<>(val);

        temp.next = tempNew;
        tempNew.next = tempNext;

        ++size;
    }

    /**
     * Метод получения хранящегося в списке значения по индексу
     *
     * @param index индекс необходимого нам элемента
     * @return Получение значения найденного элемента
     *
     * @throws IndexOutOfBoundsException при выходе за границы списка
     */
    public T find(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();

        }

        Node<T> temp = head;
        int i = 0;

        while (i != index) {
            temp = temp.next;
            ++i;

        }

        return temp.val;
    }

    /**
     * Метод удаления хранящегося в списке значения по индексу
     *
     * @param index индекс необходимого нам элемента
     *
     * @throws IndexOutOfBoundsException при выходе за границы списка
     */
    public void remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();

        }

        Node<T> temp = head;
        Node<T> tempPrev = null;
        int i = 0;

        while (i != index) {
            tempPrev = temp;
            temp = temp.next;
            ++i;

        }

        if (tempPrev == null) {
            head = temp.next;

        } else {
            tempPrev.next = temp.next;
            temp.next = null;

        }

        --size;
    }

    /**
     * Метод очистки списка
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Метод проверки списка на пустоту
     *
     * @return булевое значение
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Метод получения размерности списка
     *
     * @return размер списка
     */
    public int size() {
        return size;
    }

    /**
     * Перегруженный метод toString класса Object
     *
     * @return возвращает строку с информацией об элементах списка
     *
     */
    @Override
    public String toString() {
        String str = "[ ";
        Node<T> temp = head;

        while (temp != null) {
            str += temp.toString();
            if (temp.next != null) {
                str += " - ";
            }

            temp = temp.next;
        }

        str += " ]";

        return str;
    }
}