import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HeapTest {

    int SEED = 123;

    Heap<String> stringHeap;
    Heap<Integer> integerHeap;
    Heap<Double> doubleHeap;

    Random random = new Random(SEED);

    @Test(expected = IllegalArgumentException.class)
    public void putNullToTheHeap() {
        //given
        stringHeap = new Heap<String>();

        //when
        stringHeap.put(null);

        //then
        assert false;
    }

    @Test(expected = IllegalStateException.class)
    public void popWhenTheHeapIsEmpty() {
        //given
        stringHeap = new Heap<String>();

        //when
        stringHeap.pop();

        //then
        assert false;
    }

    @Test
    public void putOneIntegerToTheHeap() {
        //given
        integerHeap = new Heap<Integer>();
        int argument = 1;
        int poped;

        //when
        integerHeap.put(argument);
        poped = integerHeap.pop();

        //then
        assertEquals(argument, poped);
    }

    @Test
    public void putOneIntegerToTheHeapButInTheConstructor() {
        //given
        Integer[] argument = {1};
        integerHeap = new Heap<Integer>(argument);
        Integer poped;

        //when
        poped = integerHeap.pop();

        //then
        assertEquals(argument[0], poped);
    }

    @Test
    public void putThreeIntegersToTheHeap() {
        //given
        integerHeap = new Heap<Integer>();

        int first = 5, second = 3, third = 1;
        int poped1, poped2, poped3;

        //when
        integerHeap.put(first);
        integerHeap.put(second);
        integerHeap.put(third);
        poped1 = integerHeap.pop();
        poped2 = integerHeap.pop();
        poped3 = integerHeap.pop();

        //then
        assertEquals(first, poped1);
        assertEquals(second, poped2);
        assertEquals(third, poped3);
    }

    @Test
    public void putThreeIntegersToTheHeapButInTheConstructor() {
        //given
        Integer[] nums = {5, 3, 1};
        integerHeap = new Heap<Integer>(nums);

        Integer poped1, poped2, poped3;

        //when
        poped1 = integerHeap.pop();
        poped2 = integerHeap.pop();
        poped3 = integerHeap.pop();

        //then
        assertEquals(nums[0], poped1);
        assertEquals(nums[1], poped2);
        assertEquals(nums[2], poped3);
    }

    @Test
    public void putFiveIntegersToTheHeap() {
        //given
        integerHeap = new Heap<Integer>();

        int first = 7, second = 5, third = 3, forth = 2, fifth = 1;
        int poped1, poped2, poped3, poped4, poped5;

        //when
        integerHeap.put(first);
        integerHeap.put(second);
        integerHeap.put(third);
        integerHeap.put(forth);
        integerHeap.put(fifth);
        poped1 = integerHeap.pop();
        poped2 = integerHeap.pop();
        poped3 = integerHeap.pop();
        poped4 = integerHeap.pop();
        poped5 = integerHeap.pop();

        //then
        assertEquals(first, poped1);
        assertEquals(second, poped2);
        assertEquals(third, poped3);
        assertEquals(forth, poped4);
        assertEquals(fifth, poped5);
    }

    @Test
    public void putFiveIntegersToTheHeapButInTheConstructor() {
        //given
        Integer[] nums = {69, 2137, 1337, 420, 123};
        integerHeap = new Heap<Integer>(nums);

        Integer poped1, poped2, poped3, poped4, poped5;

        //when
        poped1 = integerHeap.pop();
        poped2 = integerHeap.pop();
        poped3 = integerHeap.pop();
        poped4 = integerHeap.pop();
        poped5 = integerHeap.pop();

        //then
        assertEquals(nums[1], poped1);
        assertEquals(nums[2], poped2);
        assertEquals(nums[3], poped3);
        assertEquals(nums[4], poped4);
        assertEquals(nums[0], poped5);
    }

    @Test
    public void putTenRandomDoublesToTheHeap() {
        //given
        doubleHeap = new Heap<Double>();
        Double[] expected = new Double[10];
        Double[] result = new Double[10];
        double rand;

        //when
        for (int i = 0; i < 10; i++) {
            rand = random.nextDouble();
            expected[i] = rand;
            doubleHeap.put(rand);
        }

        for (int i = 9; i >= 0; i--) {
            result[i] = doubleHeap.pop();
        }

        Arrays.sort(expected);

        //then
        assertArrayEquals(expected, result);
    }

    @Test
    public void putOneHundredRandomDoublesToTheHeap() {
        //given
        doubleHeap = new Heap<Double>();
        Double[] expected = new Double[100];
        Double[] result = new Double[100];
        double rand;

        //when
        for (int i = 0; i < 100; i++) {
            rand = random.nextDouble();
            expected[i] = rand;
            doubleHeap.put(rand);
        }

        for (int i = 99; i >= 0; i--) {
            result[i] = doubleHeap.pop();
        }

        Arrays.sort(expected);

        //then
        assertArrayEquals(expected, result);
    }

    @Test
    public void putOneThousandRandomDoublesToTheHeap() {
        //given
        doubleHeap = new Heap<Double>();
        Double[] expected = new Double[1000];
        Double[] result = new Double[1000];
        double rand;

        //when
        for (int i = 0; i < 1000; i++) {
            rand = random.nextDouble();
            expected[i] = rand;
            doubleHeap.put(rand);
        }

        for (int i = 999; i >= 0; i--) {
            result[i] = doubleHeap.pop();
        }

        Arrays.sort(expected);

        //then
        assertArrayEquals(expected, result);
    }

    @Test
    public void putTenThousandRandomDoublesToTheHeap() {
        //given
        doubleHeap = new Heap<Double>();
        Double[] expected = new Double[10000];
        Double[] result = new Double[10000];
        double rand;

        //when
        for (int i = 0; i < 10000; i++) {
            rand = random.nextDouble();
            expected[i] = rand;
            doubleHeap.put(rand);
        }

        for (int i = 9999; i >= 0; i--) {
            result[i] = doubleHeap.pop();
        }

        Arrays.sort(expected);

        //then
        assertArrayEquals(expected, result);
    }

    @Test
    public void putTenMilloinRandomDoublesToTheHeap() {
        //given
        doubleHeap = new Heap<Double>();
        Double[] expected = new Double[10000000];
        Double[] result = new Double[10000000];
        double rand;

        //when
        for (int i = 0; i < 10000000; i++) {
            rand = random.nextDouble();
            expected[i] = rand;
            doubleHeap.put(rand);
        }

        for (int i = 9999999; i >= 0; i--) {
            result[i] = doubleHeap.pop();
        }

        Arrays.sort(expected);

        //then
        assertArrayEquals(expected, result);
    }

}