public class GenericStack1<E> {
    int defaultCapacity = 2;
    private E[] list;
    private int size;

    @SuppressWarnings("unchecked") // подавление ошибки об небезопасном приведении
    public GenericStack1() {
        list = (E[]) new Object[defaultCapacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public E peek() {
        return list[size-1];
    }

    public void push(E o) {
        if (size == list.length) {
            resize();
        }
        list[size++] = o;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E o = list[--size];
        list[size] = null;
        return o;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = list.length * 2;
        E[] newList = (E[]) new Object[newCapacity];
        if (size >= 0) System.arraycopy(list, 0, newList, 0, size);
        list = newList;
    }

    @Override
    public String toString() {
        return "стек: " + list.toString();
    }
}
