
public class GenericQueue <T> extends GenericList <T> {

    // traditional reference to the tail of the list
    private Node<T> tail;

    // retrieves and removes to the tail of the list using the
    // tail data member
    public T removeTail(){
        T cur = null;
        int total = this.getLength();
        // to check if the data member is empty
        if (this.getLength() == 0) {
            return null;
        }
        // if size is one there is one element
        else if (this.getLength() == 1) {
            cur = tail.data;
            this.setHead(null) ;
            tail = null;
        }
        // size is above than one
        else{
            Node<T> prev = null;
            Node<T> cur_1 = this.getHead();
            while(cur_1.next != null){
                prev = cur_1;
                cur_1 = cur_1.next;
            }
            cur = tail.data;
            prev.next = null;
            this.tail = prev;
        }
        total-=1;
        this.setLength(total);
        return cur;
    }

    // each constructor should initialize linked list head
    public GenericQueue(T value) {
        // set the head and tail data members
        Node <T> cur = new Node <T>(value);
        Node <T> first = cur;
        this.setHead(first);
        this.setLength(1);
        this.tail = cur;
    }

    public void add(T data) {
        Node <T> temp = new Node <T>(data);
        Node <T> cur = this.getHead();
        // to keep track of the number of element
        int cur_length = 0;
        cur_length = this.getLength();
        // to check if the inside of the element is empty
        if(cur == null){
            cur = temp;
            this.setHead(cur);
        }
        else{
            this.tail.next = temp;
        }
        tail = temp;
        // adding an element
        cur_length+=1;
        this.setLength(cur_length);
    }

    //for user expect these calls to be implemented in each of those data structures
    public void enqueue(T data) {
        // call methods add(T data)
        this.add(data);
    }

    public T dequeue() {
        // call methods delete
        T cur = this.delete();
        return cur;
    }
}