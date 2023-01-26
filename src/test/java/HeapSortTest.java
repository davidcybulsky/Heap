import Interfaces.HeapSortInterface;
import org.junit.Test;

public class HeapSortTest {

    HeapSortInterface<Double> sorter;

    @Test
    public void sortFiveElementArray() {

        //given
        sorter = new HeapSort<Double>();
        Double[] nums = new Double[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = (double) i;
        }
        sorter.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    @Test
    public void sortFiveElementArray2() {

        //given
        sorter = new HeapSort<Double>();
        Double[] nums = new Double[5];
        int j = 0;
        for (int i = 10; i > 5; i--) {
            nums[j++] = (double) i;
        }
        sorter.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}