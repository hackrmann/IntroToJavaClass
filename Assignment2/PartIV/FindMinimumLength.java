import java.lang.reflect.Array;
import java.util.Arrays;

class FindMinimumLength {

    public static int minSubArrayLen(int goal, int[] nums) {
        int minimumLength = Integer.MAX_VALUE;
        int sum = 0, beginWindow = 0, presentWindow = 0, endWindow = 0;
//        System.out.println(Arrays.toString(nums));
        for (endWindow = 1; endWindow <= nums.length; endWindow++) {
            sum += nums[endWindow-1];
            presentWindow = beginWindow;
            if (sum >= goal) {
                while (sum >= goal) {
                    sum -= nums[presentWindow++];
                }
                beginWindow = presentWindow - 1;
                sum+= nums[beginWindow];
                minimumLength = Integer.min(minimumLength, endWindow - beginWindow);
            }
        }
        if (minimumLength == Integer.MAX_VALUE) return 0;
        return minimumLength;
    }

    public static void main(String[] args) {
        int[] array1 = {10, 2, 3, 11};
        System.out.println(minSubArrayLen(11, array1));
        int[] array2 = {5, 6, 8, 2};
        System.out.println(minSubArrayLen(7, array2));
    }
}
