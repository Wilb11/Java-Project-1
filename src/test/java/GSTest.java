// Wilbert Limson UIN 671689847
// GSTesting

import java.util.Iterator;
import java.util.ListIterator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GSTest {

    // generic queue decleration
    private GenericStack < Integer > int_test;

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
        int_test = new GenericStack < >(5);
        int_test.add(10);
        int_test.add(15);
    }

    // test the add method to check if all the elements are added
    @ParameterizedTest@ValueSource(ints = {5, 10, 15})

    void T_1(){
        assertEquals(10, int_test.get(1), "wrong answer");
    }


    @Test
    void T_2() {
        assertEquals(15, int_test.pop(), "wrong answer");
    }

    @Test
    void T_3(){
        assertEquals(5, int_test.removeTail(), "wrong answer");
    }

    @Test
    void T_4(){
        GenericStack <Integer> int_queue = new GenericStack < >(15);
        assertEquals(15, int_queue.getHead().data, "wrong answer");
    }

    @Test
    void T_5(){
        GenericStack <Integer> int_queue = new GenericStack < >(5);
        int_queue.push(10);
        int_queue.push(15);
        ListIterator <Integer> it = int_queue.listIterator(1);
        assertEquals( 0, it.previousIndex(), "wrong answer");
    }

    @Test
    void T_6(){
        GenericStack <Integer> int_queue = new GenericStack <>(5);
        ListIterator <Integer> it = int_queue.listIterator(1);
        assertEquals(false, it.hasNext(), "wrong answer");
    }

    @Test
    void T_7() {
        int_test.push(1);
        Iterator<Integer> iterator_8 = int_test.descendingIterator();
        assertEquals(5, iterator_8.next());
    }

    @Test
    void T_8(){
        int_test.push(1);
        Iterator<Integer> reverseIterator = int_test.iterator();
        assertEquals(1, reverseIterator.next());
    }

    @Test
    void T_9(){
        GenericStack < Integer > int_stack = new GenericStack < >(5);
        int_stack.push(10);
        int_stack.push(15);
        assertEquals(int_stack.get(1), 10, "wrong answer");
    }
}