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
}