// Wilbert Limson UIN 671689847

import java.util.Iterator;

public class GLLIterator <E> implements Iterator <E>{

    private GenericList <E> .Node <E> cur;

    public GLLIterator(GenericList <E> .Node <E> head){
        this.cur = head;
    }

    @Override
    public boolean hasNext(){
        if (this.cur == null) {
            return false;
        }
        return true;
    }

    @Override
    public E next(){
        E temp = this.cur.data;
        this.cur = this.cur.next;
        return temp;
    }

}