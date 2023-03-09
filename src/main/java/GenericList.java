// Wilbert Limson uin 671689847
// main file of generic list Java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.lang.Iterable;

public abstract class GenericList<T> implements Iterable<T> {

    // through this it will implement iterable<t> interface
    @Override
    public Iterator<T> iterator() {
        GLLIterator<T> itr = new GLLIterator<>(this.getHead());
        return itr;
    }

    // class define a generic immer class
    public class Node<T> {
        // two fields
        T data;
        Node<T> next;

        // the inner class will also provide a single arg constructor
        // set data equal to val
        public Node(T val) {
            // the inner class is to be used to create nodes
            this.next = null;
            this.data = val;
        }
    }

    // this class will contain only two data fields
    private Node<T> head; //head list and should be private
    private int length; // length of the list and should be private

    // sets the updated position of head
    public void setHead(Node<T> head) {
        this.head = head;
    }

    // sets the updated position of length
    public void setLength(int length) {
        this.length = length;
    }

    // get updated position of head
    public Node<T> getHead() {
        return this.head;
    }

    // get updated position of length
    public int getLength() {
        return this.length;
    }

    // prints the items of the list, one value per line. If the list is empty, print “Empty List”.
    public void print() {
        // if there is something to print
        if (length >= 1) {
            Node<T> cur = this.getHead();
            while (cur != null) {
                System.out.println(cur.data + "\n");
                cur = cur.next;
            }
        }// if there is nothing to print
        else {
            System.out.println("Empty List");
        }
    }

    // adds the value to the list. This method is abstract since the
    // implementation depends on what the data structure is.
    public abstract void add(T data);

    // returns the first value of the list and deletes the node. If the list is empty, return null.
    public T delete() {        // if the list is empty return null
        if (this.length <= 0) {
            return null;
        } else {
            Node<T> cur = head;
            head = head.next;
            length--;
            return cur.data;
        }
    }

    // This method stores and returns all values currently in the list into an ArrayList and returns it.
    // At the end of this method, your list should be empty.
    public ArrayList<T> dumpList() {
        // temporary list
        ArrayList<T> curList = new ArrayList<T>();
        Node<T> cur = this.getHead();
//        stores and returns all values currently in the list into an ArrayList
        while (cur != null) {
            curList.add(cur.data);
            cur = cur.next;
        }
        // reset
        this.head = null;
        this.length = 0;
        // return at the end
        return curList;
    }

    // returns the value at the specified index or null if the index is out of bounds.
    public T get(int index) {
        // get the current position of the null
        Node<T> cur = head;
        int count = 0;
        // to check if it's out of bound
        if (index < 0 || index >= length) {
            return null;
        }
        // to get the
        else {
            while (count < index) {
                cur = cur.next;
                count++;
            }
        }
        return cur.data;
    }

    // replace the element at specified position in the list
    // with the specified element and return the element previously at the specified position.
    // Return null if index is out of bounds
    public T set(int index, T element) {
        // get the current position of the null
        Node<T> cur = head;
        int count = 0;
        if ((index < 0) || (index >= length)) {
            return null;
        } else {
            while (count < index) {
                cur = cur.next;
                count++;
            }
        }

        T prevValue = cur.data;
        cur.data = element;

        return prevValue;
    }

    public ListIterator<T> listIterator(int index) {
        GLListIterator<T> temp = new GLListIterator<T>(this);
        for (int count = 0; temp.hasNext(); count++) {
            if (count == index) {
                return temp;
            }
            temp.next();
        }
        return temp;
    }

    public Iterator<T> descendingIterator() {
        ReverseGLLIterator<T> temp = new ReverseGLLIterator<T>(this);
        return temp;
    }
}