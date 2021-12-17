package es.datastructur.synthesizer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Jiaxian Gu
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(5);
        arb.enqueue("A");
        arb.enqueue("A");
        arb.enqueue("3");
        arb.enqueue("A");
        arb.enqueue("A");
//        arb.enqueue(3);
        System.out.println(arb.dequeue());
        System.out.println(arb.dequeue());
        System.out.println(arb.dequeue());
        System.out.println(arb.dequeue());
        System.out.println(arb.dequeue());
//        System.out.println(arb.dequeue());

    }

    @Test
    public void someTest2() {
        List lst = new ArrayList();
        ArrayRingBuffer arb1 = new ArrayRingBuffer(10);
        ArrayRingBuffer arb2 = new ArrayRingBuffer(10);
        arb1.enqueue("A");
        arb1.enqueue("A");
        arb1.enqueue("A");
        arb1.enqueue("A");
        arb1.enqueue("A");
        arb1.dequeue();
        arb1.dequeue();
        arb1.dequeue();
        arb1.enqueue("3");
        arb1.enqueue("4");
        arb1.enqueue("5");


        arb2.enqueue("A");
        arb2.enqueue("A");
        arb2.enqueue("3");
        arb2.enqueue("4");
        arb2.enqueue("5");

        lst.add("A");
        lst.add("A");
        lst.add("3");
        lst.add("4");
        lst.add("5");

        System.out.println(arb1.equals(arb2));
        System.out.println(arb1.equals(lst));
    }
}
