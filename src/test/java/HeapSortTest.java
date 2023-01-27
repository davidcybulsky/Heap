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

    Random random = new Random(SEED);
    BufferedReader reader;

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

}