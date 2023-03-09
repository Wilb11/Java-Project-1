import java.util.ListIterator;

public class GLListIterator <E> implements ListIterator <E> {

    private GenericList <E> .Node <E> head;
    private GenericList <E> tail;

    private int size;

    //declaration
    public GLListIterator(GenericList <E> GenericList) {
        head = GenericList.getHead();
        this.tail = GenericList;
        size = 0;
    }

    // logic to iterate from the list in reverse
    @Override
    public boolean hasNext() {
        if (head == null) {
            return false;
        }
        else {
            return true;
        }
    }

    //
    @Override
    public E next() {
        E temp = head.data;
        head = head.next;
        size = size +1;
        return temp;
    }

    //
    @Override
    public boolean hasPrevious() {
        int CurPos = size -1;
        if (this.tail.get(CurPos) == null) {
            return false;
        }
        return true;
    }

    //
    @Override
    public E previous() {
        int curPos = size - 1;
        E temp = tail.get(curPos);
        size = size-1;
        return temp;
    }

    //
    @Override
    public int nextIndex() {
        int totalSize = tail.getLength() - 1;
        int temp = 0;
        if (size < totalSize) {
            temp = size + 1;
            return temp;
        }
        else {
            return size;
        }
    }

    //
    @Override
    public int previousIndex() {
        int temp = 0;
        if (size >= 0) {
            return temp = size - 1;
        }
        return - 1;
    }

    @Override
    public void remove() {
    }

    @Override
    public void set(E e) {
    }

    @Override
    public void add(E e) {
    }

}