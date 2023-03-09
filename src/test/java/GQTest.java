// Wilbert Limson UIN 671689847
// GQ testing
import java.util.Iterator;
import java.util.ListIterator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GQTest {

    // generic queue decleration
    private GenericQueue < Integer > int_test;

    // iterator decleration
    private static int int_iter;

    // set up the first amount of number
    @BeforeAll
    static void iterator() {
        int_iter = 0;
    }

    // setting up the value inside
    @BeforeEach
    void decleration() {
        int_test = new GenericQueue < >(5);
        int_test.add(10);
        int_test.add(15);
    }

    // test the add method to check if all the elements are added
    @ParameterizedTest@ValueSource(ints = {5, 10, 15})

    void T_1(int val) {
        assertEquals(val, int_test.get(int_iter), "wrong answer because the value is equal");
        int_iter++;
    }

    @Test
    void T_2(){
        assertEquals(10, int_test.get(1), "wrong answer");
    }


    @Test
    void T_3() {
        assertEquals(5, int_test.dequeue(), "wrong answer");
    }

    @Test
    void T_4(){
        assertEquals(15, int_test.removeTail(), "wrong answer");
    }

    @Test
    void T_5(){
        GenericQueue <Integer> int_queue = new GenericQueue < >(15);
        assertEquals(15, int_queue.getHead().data, "wrong answer");
    }

    @Test
    void T_6(){
        GenericQueue <Integer> int_queue = new GenericQueue < >(5);
        int_queue.enqueue(10);
        int_queue.enqueue(15);
        ListIterator <Integer> it = int_queue.listIterator(1);
        assertEquals( 0, it.previousIndex(), "wrong answer");
    }

    @Test
    void T_7(){
        GenericQueue <Integer> int_queue = new GenericQueue <>(5);
        ListIterator <Integer> it = int_queue.listIterator(1);
        assertEquals(false, it.hasNext(), "wrong answer");
    }

    @Test
    void T_8() {
        int_test.enqueue(1);
        Iterator<Integer> iterator_8 = int_test.descendingIterator();
        assertEquals(1, iterator_8.next());
    }

    @Test
    void T_9(){
        int_test.enqueue(1);
        Iterator<Integer> reverseIterator = int_test.iterator();
        assertEquals(5, reverseIterator.next());
    }
}