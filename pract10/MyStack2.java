import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class MyStack2<E> extends ArrayList<E> implements Cloneable {
    public int getSize() {
        return size();
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return get(size() - 1);
    }

    public void push(E value) {
        add(value);
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return remove(size() - 1);
    }

    /** Так как в ArrayList элементы хранятся в виде массива (соответственно это поле не объектного типа),
     * то для глубокого копирования будет достаточно такой реализации.
      */

    @Override
    public MyStack2<E> clone() {
        return (MyStack2<E>)super.clone();
    }
}
