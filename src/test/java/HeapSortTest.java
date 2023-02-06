import Interfaces.HeapSortInterface;
import org.junit.Assert;
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

    //Exceptions
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

    //Strings
    @Test
    public void arraySizeIsEqualsTo0String() {
        //given
        stringSorter = new HeapSort<String>();
        String[] strings = new String[0];
        String[] expected = new String[0];

        //when
        stringSorter.sort(strings);

        //than
        Assert.assertArrayEquals(expected, strings);
    }

    @Test
    public void sortAnArrayWithOneElementString() {
        //given
        stringSorter = new HeapSort<String>();
        String[] strings = {"Java"};
        String[] expected = {"Java"};

        //when
        stringSorter.sort(strings);

        //than
        assertArrayEquals(expected, strings);
    }

    @Test
    public void sortTenThousandWords() throws IOException {
        //given
        stringSorter = new HeapSort<String>();
        reader = new BufferedReader(new FileReader("10000words"));
        String[] strings = new String[10000];
        String[] expected = new String[10000];
        String input = null;

        for (int i = 0; i < 10000; i++) {
            input = reader.readLine();
            strings[i] = input;
            expected[i] = input;
        }

        sort(expected);

        //when
        stringSorter.sort(strings);

        //then
        assertArrayEquals(expected, strings);
    }

    @Test
    public void sortTenThousandReversedWords() throws IOException {
        //given
        stringSorter = new HeapSort<String>();
        reader = new BufferedReader(new FileReader("10000words"));
        String[] strings = new String[10000];
        String[] expected = new String[10000];
        String input = null;

        for (int i = 9999; i >= 0; i--) {
            input = reader.readLine();
            strings[i] = input;
            expected[i] = input;
        }

        sort(expected);

        //when
        stringSorter.sort(strings);

        //then
        assertArrayEquals(expected, strings);
    }

    @Test
    public void loremIpsumSortFor1Line() throws IOException {
        //given
        stringSorter = new HeapSort<String>();
        reader = new BufferedReader(new FileReader("LoremIpsum"));
        String[] strings = new String[1];
        String[] expected = new String[1];
        String input = null;

        for (int i = 0; i < 1; i++) {
            input = reader.readLine();
            strings[i] = input;
            expected[i] = input;
        }

        sort(expected);

        //when
        stringSorter.sort(strings);

        //then
        assertArrayEquals(expected, strings);
    }

    @Test
    public void loremIpsumSortFor10Lines() throws IOException {
        //given
        stringSorter = new HeapSort<String>();
        reader = new BufferedReader(new FileReader("LoremIpsum"));
        String[] strings = new String[10];
        String[] expected = new String[10];
        String input = null;

        for (int i = 0; i < 10; i++) {
            input = reader.readLine();
            strings[i] = input;
            expected[i] = input;
        }

        sort(expected);

        //when
        stringSorter.sort(strings);

        //then
        assertArrayEquals(expected, strings);
    }

    @Test
    public void loremIpsumSortFor100Lines() throws IOException {
        //given
        stringSorter = new HeapSort<String>();
        reader = new BufferedReader(new FileReader("LoremIpsum"));
        String[] strings = new String[100];
        String[] expected = new String[100];
        String input = null;

        for (int i = 0; i < 100; i++) {
            input = reader.readLine();
            strings[i] = input;
            expected[i] = input;
        }

        sort(expected);

        //when
        stringSorter.sort(strings);

        //then
        assertArrayEquals(expected, strings);
    }

    @Test
    public void loremIpsumSortFor200Lines() throws IOException {
        //given
        stringSorter = new HeapSort<String>();
        reader = new BufferedReader(new FileReader("LoremIpsum"));
        String[] strings = new String[200];
        String[] expected = new String[200];
        String input = null;

        for (int i = 0; i < 200; i++) {
            input = reader.readLine();
            strings[i] = input;
            expected[i] = input;
        }

        sort(expected);

        //when
        stringSorter.sort(strings);

        //then
        assertArrayEquals(expected, strings);
    }

    //Doubles
    @Test
    public void sortAnArrayWithOneElementDouble() {
        //given
        doubleSorter = new HeapSort<Double>();
        Double[] doubles = {34.89};
        Double[] expected = {34.89};

        //when
        doubleSorter.sort(doubles);

        //than
        assertArrayEquals(expected, doubles);
    }

    @Test
    public void sortFiveElementArraySortedDoubles() {

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
    public void sortFiveElementArrayReversedDoubles() {

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

    //Integers
    @Test
    public void sortFiveElementArraySortedIntegers() {

        //given
        integerSorter = new HeapSort<Integer>();
        Integer[] nums = new Integer[5];
        Integer[] expected = new Integer[5];

        for (int i = 0; i < 5; i++) {
            nums[i] = i;
            expected[i] = i;
        }

        //when
        integerSorter.sort(nums);
        sort(expected);

        //then
        assertArrayEquals(expected, nums);
    }

    @Test
    public void sortFiveElementArrayReversedIntegers() {

        //given
        integerSorter = new HeapSort<Integer>();
        Integer[] nums = new Integer[5];
        Integer[] expected = new Integer[5];
        int j = 0;

        for (int i = 10; i > 5; i--) {
            nums[j] = i;
            expected[j++] = i;
        }

        //when
        integerSorter.sort(nums);
        sort(expected);

        //then
        assertArrayEquals(expected, nums);
    }

    @Test
    public void sortAnArrayWithOneElementInteger() {
        //given
        integerSorter = new HeapSort<Integer>();
        Integer[] ints = {34};
        Integer[] expected = {34};

        //when
        integerSorter.sort(ints);

        //than
        assertArrayEquals(expected, ints);
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