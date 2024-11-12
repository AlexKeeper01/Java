import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class MyStack<E> implements Cloneable {
    ArrayList<E> list = new ArrayList<>();

    boolean isEmpty() {
        return list.isEmpty();
    }

    int getSize() {
        return list.size();
    }

    E peek(){
        return list.get(getSize() - 1);
    }

    E pop(){
        return list.remove(getSize() - 1);
    }

    void push(E e){
        list.add(e);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MyStack<E> NewStack = (MyStack<E>)super.clone();
        NewStack.list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            NewStack.list.add((E)list.get(i));
        }
        return NewStack;
    }
}
