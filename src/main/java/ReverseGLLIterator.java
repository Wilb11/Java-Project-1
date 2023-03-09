// Wilbert Limson UIN 671689847
//rEVERSE GL iterator
// it will be identical to GLLIterator
import java.util.Iterator;

public class ReverseGLLIterator <E> implements Iterator <E> {

    private GenericList <E> curlist;
    private int pos;

    // constructor of the reverse GLI iterator
    public ReverseGLLIterator(GenericList <E> GenericList) {
        this.curlist = GenericList;
        pos = (curlist.getLength() - 1);
    }

    @Override
    public boolean hasNext() {
        if (this.curlist.get(pos) == null) {
            return false;
        }
        return true;
    }

    @Override
    public E next() {
        E currentVal = curlist.get(pos);
        pos = pos - 1;
        return currentVal;
    }

}
