import Interfaces.HeapSortInterface;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import static java.util.Arrays.sort;
import static org.junit.Assert.assertArrayEquals;

public class HeapSortTest {

    int SEED = 69;

    HeapSortInterface<Double> doubleSorter;
    HeapSortInterface<String> stringSorter;
    HeapSortInterface<Integer> integerSorter;

    Random random = new Random(SEED);
    BufferedReader reader;

    @Test(expected = IllegalArgumentException.class)
    public void arrayOfIntegersWithNulls() {
        //given
        integerSorter = new HeapSort<Integer>();

        Integer[] nums = new Integer[10];

        for (int i = 0; i < 10; i++) {
            nums[i] = random.nextInt();
        }

        nums[random.nextInt(10)] = null;

        //when
        integerSorter.sort(nums);

        //then
        assert false;
    }

    @Test(expected = IllegalArgumentException.class)
    public void arrayOfStringsWithNulls() {
        //given
        stringSorter = new HeapSort<String>();

        String[] strings = {"aaa", "mam", "have", "has", "avoir", "Johnny", "twee", "bunny", "char", "charnek"};

        strings[random.nextInt(10)] = null;

        //when
        stringSorter.sort(strings);

        //then
        assert false;
    }

    @Test(expected = IllegalArgumentException.class)
    public void arrayIsNull() {
        //given
        doubleSorter = new HeapSort<Double>();
        Double[] nums = null;

        //when
        doubleSorter.sort(nums);

        //then
        assert false;
    }

    @Test(expected = IllegalArgumentException.class)
    public void argumentInTheArrayIsNull() {
        //given
        doubleSorter = new HeapSort<Double>();
        Double[] nums = {null};

        //when
        doubleSorter.sort(nums);

        //then
        assert false;
    }


    @Test
    public void sortFiveElementArray() {

        //given
        doubleSorter = new HeapSort<Double>();
        Double[] nums = new Double[5];
        Double[] expected = new Double[5];

        for (int i = 0; i < 5; i++) {
            nums[i] = (double) i;
            expected[i] = (double) i;
        }

        //when
        doubleSorter.sort(nums);
        sort(expected);

        //then
        assertArrayEquals(expected, nums);
    }

    @Test
    public void sortFiveElementArray2() {

        //given
        doubleSorter = new HeapSort<Double>();
        Double[] nums = new Double[5];
        Double[] expected = new Double[5];
        int j = 0;

        for (int i = 10; i > 5; i--) {
            nums[j] = (double) i;
            expected[j++] = (double) i;
        }

        //when
        doubleSorter.sort(nums);
        sort(expected);

        //then
        assertArrayEquals(expected, nums);
    }

    @Test
    public void sortOneHundredElements() {
        //given
        doubleSorter = new HeapSort<Double>();
        Double[] nums = new Double[100];
        Double[] expected = new Double[100];
        double rand;

        for (int i = 0; i < 100; i++) {
            rand = random.nextDouble();
            nums[i] = rand;
            expected[i] = rand;
        }

        Arrays.sort(expected);

        //when
        doubleSorter.sort(nums);

        //then
        assertArrayEquals(expected, nums);

    }

    @Test
    public void sortTenThousandWords() throws IOException {
        //given
        stringSorter = new HeapSort<String>();
        reader = new BufferedReader(new FileReader("10000words"));
        String[] nums = new String[10000];
        String[] expected = new String[10000];
        String input = null;

        for (int i = 0; i < 10000; i++) {
            input = reader.readLine();
            nums[i] = input;
            expected[i] = input;
        }

        sort(expected);

        //when
        stringSorter.sort(nums);

        //then
        assertArrayEquals(expected, nums);
    }

    @Test
    public void sortTenThousandReversedWords() throws IOException {
        //given
        stringSorter = new HeapSort<String>();
        reader = new BufferedReader(new FileReader("10000words"));
        String[] nums = new String[10000];
        String[] expected = new String[10000];
        String input = null;

        for (int i = 9999; i >= 0; i--) {
            input = reader.readLine();
            nums[i] = input;
            expected[i] = input;
        }

        sort(expected);

        //when
        stringSorter.sort(nums);

        //then
        assertArrayEquals(expected, nums);
    }

    @Test
    public void tenThousandRandomDoubles() {
        //given
        doubleSorter = new HeapSort<Double>();

        Double[] nums = new Double[10000];
        Double[] expected = new Double[10000];
        double rand;

        for (int i = 0; i < 10000; i++) {
            rand = random.nextDouble();
            nums[i] = rand;
            expected[i] = rand;
        }

        sort(expected);

        //when
        doubleSorter.sort(nums);

        //then
        assertArrayEquals(expected, nums);
    }

    @Test
    public void oneHundredThousandRandomDoubles() {
        //given
        doubleSorter = new HeapSort<Double>();

        Double[] nums = new Double[100000];
        Double[] expected = new Double[100000];
        double rand;

        for (int i = 0; i < 100000; i++) {
            rand = random.nextDouble();
            nums[i] = rand;
            expected[i] = rand;
        }

        sort(expected);

        //when
        doubleSorter.sort(nums);

        //then
        assertArrayEquals(expected, nums);
    }

    @Test
    public void oneMillionRandomDoubles() {
        //given
        doubleSorter = new HeapSort<Double>();

        Double[] nums = new Double[1000000];
        Double[] expected = new Double[1000000];
        double rand;

        for (int i = 0; i < 1000000; i++) {
            rand = random.nextDouble();
            nums[i] = rand;
            expected[i] = rand;
        }

        sort(expected);

        //when
        doubleSorter.sort(nums);

        //then
        assertArrayEquals(expected, nums);
    }

    @Test
    public void tenMillionRandomDoubles() {
        //given
        doubleSorter = new HeapSort<Double>();

        Double[] nums = new Double[10000000];
        Double[] expected = new Double[10000000];
        double rand;

        for (int i = 0; i < 10000000; i++) {
            rand = random.nextDouble();
            nums[i] = rand;
            expected[i] = rand;
        }

        sort(expected);

        //when
        doubleSorter.sort(nums);

        //then
        assertArrayEquals(expected, nums);
    }

    @Test
    public void oneThousandRandomIntegers() {
        //given
        integerSorter = new HeapSort<Integer>();

        Integer[] nums = new Integer[1000];
        Integer[] expected = new Integer[1000];
        int rand;

        for (int i = 0; i < 1000; i++) {
            rand = random.nextInt();
            nums[i] = rand;
            expected[i] = rand;
        }

        sort(expected);

        //when
        integerSorter.sort(nums);

        //then
        assertArrayEquals(expected, nums);
    }

    @Test
    public void tenThousandRandomIntegers() {
        //given
        integerSorter = new HeapSort<Integer>();

        Integer[] nums = new Integer[10000];
        Integer[] expected = new Integer[10000];
        int rand;

        for (int i = 0; i < 10000; i++) {
            rand = random.nextInt();
            nums[i] = rand;
            expected[i] = rand;
        }

        sort(expected);

        //when
        integerSorter.sort(nums);

        //then
        assertArrayEquals(expected, nums);
    }

    @Test
    public void oneHundredThousandRandomIntegers() {
        //given
        integerSorter = new HeapSort<Integer>();

        Integer[] nums = new Integer[100000];
        Integer[] expected = new Integer[100000];
        int rand;

        for (int i = 0; i < 100000; i++) {
            rand = random.nextInt();
            nums[i] = rand;
            expected[i] = rand;
        }

        sort(expected);

        //when
        integerSorter.sort(nums);

        //then
        assertArrayEquals(expected, nums);
    }

    @Test
    public void oneMillionRandomIntegers() {
        //given
        integerSorter = new HeapSort<Integer>();

        Integer[] nums = new Integer[1000000];
        Integer[] expected = new Integer[1000000];
        int rand;

        for (int i = 0; i < 1000000; i++) {
            rand = random.nextInt();
            nums[i] = rand;
            expected[i] = rand;
        }

        sort(expected);

        //when
        integerSorter.sort(nums);

        //then
        assertArrayEquals(expected, nums);
    }

    @Test
    public void tenMillionRandomIntegers() {
        //given
        integerSorter = new HeapSort<Integer>();

        Integer[] nums = new Integer[10000000];
        Integer[] expected = new Integer[10000000];
        int rand;

        for (int i = 0; i < 10000000; i++) {
            rand = random.nextInt();
            nums[i] = rand;
            expected[i] = rand;
        }

        sort(expected);

        //when
        integerSorter.sort(nums);

        //then
        assertArrayEquals(expected, nums);
    }

}