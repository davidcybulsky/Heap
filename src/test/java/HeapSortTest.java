import Interfaces.HeapSortInterface;
import org.junit.Test;

import static java.util.Arrays.sort;
import static org.junit.Assert.assertArrayEquals;

public class HeapSortTest {

    HeapSortInterface<Double> doubleSorter;

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
}