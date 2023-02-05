import java.lang.reflect.Array;
import java.util.Arrays;

class FindMinimumLength {

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i > -1; i--)
            heapify(array, array.length, i);

        for (int i = array.length - 1; i > -1; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) largest = left;
        if (right < n && array[right] > array[largest]) largest = right;

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }

    public static int minSubArrayLen(int goal, int[] nums) {
        int minimumLength = 0;
        int sum = 0;
        heapSort(nums);
//        System.out.println(Arrays.toString(nums));
        for (int i = nums.length - 1; i > -1; i--) {
            sum += nums[i];
            minimumLength++;
            if (sum >= goal) {
                break;
            }
        }
        return minimumLength;
    }

    public static void main(String[] args) {
        int[] array1 = {10, 2, 3, 11};
        System.out.println(minSubArrayLen(11, array1));
        int[] array2 = {5, 6, 8, 2};
        System.out.println(minSubArrayLen(7, array2));
    }
}
