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

    //Exceptions
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
    public void sizeTest() {
        //given
        integerHeap = new Heap<Integer>();

        //when
        integerHeap.put(1);
        int afterFirstPut = integerHeap.getSize();
        integerHeap.put(2);
        int afterSecondPut = integerHeap.getSize();
        integerHeap.put(3);
        int afterThirdPut = integerHeap.getSize();
        integerHeap.put(4);
        int afterForthPut = integerHeap.getSize();
        integerHeap.put(5);
        int afterFifthPut = integerHeap.getSize();

        //then
        assertEquals(1, afterFirstPut);
        assertEquals(2, afterSecondPut);
        assertEquals(3, afterThirdPut);
        assertEquals(4, afterForthPut);
        assertEquals(5, afterFifthPut);
    }

    @Test
    public void sizeTestWithPop() {
        //given
        integerHeap = new Heap<Integer>();

        //when
        integerHeap.put(1);
        int afterFirstPut = integerHeap.getSize();
        integerHeap.pop();
        integerHeap.put(2);
        int afterSecondPut = integerHeap.getSize();
        integerHeap.pop();
        integerHeap.put(3);
        int afterThirdPut = integerHeap.getSize();
        integerHeap.pop();
        integerHeap.put(4);
        int afterForthPut = integerHeap.getSize();
        integerHeap.pop();
        integerHeap.put(5);
        int afterFifthPut = integerHeap.getSize();
        integerHeap.pop();

        //then
        assertEquals(1, afterFirstPut);
        assertEquals(1, afterSecondPut);
        assertEquals(1, afterThirdPut);
        assertEquals(1, afterForthPut);
        assertEquals(1, afterFifthPut);
        assertEquals(0, integerHeap.getSize());
    }

    @Test
    public void heapPutAndPopIntegers() {
        //given
        integerHeap = new Heap<>();
        int i1 = 0;
        int i2 = 1;
        int i3 = 2;
        int i4 = 4;

        //when
        integerHeap.put(i1);
        integerHeap.put(i2);
        integerHeap.put(i3);
        int geti3 = integerHeap.pop();
        integerHeap.put(i3);
        int geti3second = integerHeap.pop();
        int geti2 = integerHeap.pop();
        integerHeap.put(i2);
        int geti2second = integerHeap.pop();
        int geti1 = integerHeap.pop();
        integerHeap.put(i4);
        integerHeap.put(i3);
        integerHeap.put(i2);
        integerHeap.put(i1);
        int geti4 = integerHeap.pop();
        int geti3third = integerHeap.pop();
        int geti2third = integerHeap.pop();
        int geti1second = integerHeap.pop();

        //then
        assertEquals(i3, geti3);
        assertEquals(i3, geti3second);
        assertEquals(i2, geti2);
        assertEquals(i2, geti2second);
        assertEquals(i1, geti1);
        assertEquals(i4, geti4);
        assertEquals(i3, geti3third);
        assertEquals(i2, geti2third);
        assertEquals(i1, geti1second);
    }

    @Test
    public void heapPutAndPopStrings() {
        //given
        stringHeap = new Heap<>();
        String s1 = "ala";
        String s2 = "basia";
        String s3 = "kasia";
        String s4 = "zosia";

        //when
        stringHeap.put(s1);
        stringHeap.put(s2);
        stringHeap.put(s3);
        String gets3 = stringHeap.pop();
        stringHeap.put(s3);
        String gets3second = stringHeap.pop();
        String gets2 = stringHeap.pop();
        stringHeap.put(s2);
        String gets2second = stringHeap.pop();
        String gets1 = stringHeap.pop();
        stringHeap.put(s4);
        stringHeap.put(s3);
        stringHeap.put(s2);
        stringHeap.put(s1);
        String gets4 = stringHeap.pop();
        String gets3third = stringHeap.pop();
        String gets2third = stringHeap.pop();
        String gets1second = stringHeap.pop();

        //then
        assertEquals(s3, gets3);
        assertEquals(s3, gets3second);
        assertEquals(s2, gets2);
        assertEquals(s2, gets2second);
        assertEquals(s1, gets1);
        assertEquals(s4, gets4);
        assertEquals(s3, gets3third);
        assertEquals(s2, gets2third);
        assertEquals(s1, gets1second);
    }

    @Test
    public void heapPutAndPopDoubles() {
        //given
        doubleHeap = new Heap<>();
        double d1 = 0.9;
        double d2 = 2.1;
        double d3 = 3.7;
        double d4 = 6.9;

        //when
        doubleHeap.put(d1);
        doubleHeap.put(d2);
        doubleHeap.put(d3);
        double getd3 = doubleHeap.pop();
        doubleHeap.put(d3);
        double getd3second = doubleHeap.pop();
        double getd2 = doubleHeap.pop();
        doubleHeap.put(d2);
        double getd2second = doubleHeap.pop();
        double getd1 = doubleHeap.pop();
        doubleHeap.put(d4);
        doubleHeap.put(d3);
        doubleHeap.put(d2);
        doubleHeap.put(d1);
        double getd4 = doubleHeap.pop();
        double getd3third = doubleHeap.pop();
        double getd2third = doubleHeap.pop();
        double getd1second = doubleHeap.pop();

        //then
        assertEquals(d3, getd3, 0);
        assertEquals(d3, getd3second, 0);
        assertEquals(d2, getd2, 0);
        assertEquals(d2, getd2second, 0);
        assertEquals(d1, getd1, 0);
        assertEquals(d4, getd4, 0);
        assertEquals(d3, getd3third, 0);
        assertEquals(d2, getd2third, 0);
        assertEquals(d1, getd1second, 0);
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
        assertEquals(0, integerHeap.getSize());
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
        assertEquals(0, integerHeap.getSize());
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
        assertEquals(0, integerHeap.getSize());
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
        assertEquals(0, integerHeap.getSize());
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
        assertEquals(0, integerHeap.getSize());
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
        assertEquals(0, integerHeap.getSize());
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
        assertEquals(0, doubleHeap.getSize());
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
        assertEquals(0, doubleHeap.getSize());
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
        assertEquals(0, doubleHeap.getSize());
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
        assertEquals(0, doubleHeap.getSize());
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
        assertEquals(0, doubleHeap.getSize());
    }

}