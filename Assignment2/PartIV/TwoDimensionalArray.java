import java.util.Arrays;

public class TwoDimensionalArray {

    public static void main(String[] args) {

        int[][] twoDimArray = new int[2][5];
        int[] arrayOne = {5, 9, 55, 23, 89};
        int[] arrayTwo = {15, 3, 23, 19, 64};

        /* copy arrayOne and arrayTwo into twoDimArray */
        /* print out the first list of 5 numbers in twoDimArray
         * on one line, and the second list of 5 numbers in twoDimArray
         * on the next line
         */

        /* the solution should use nested loops: one loop to loop over
         * each array in twoDimArray, and one loop to loop over each element
         * in that array
         */
        for (int i = 0; i < twoDimArray.length; i++) {      //Since the question statement asks us to use nested loops
            for (int j = 0; j < twoDimArray[i].length; j++) {
                if (i == 0) {
                    twoDimArray[i][j] = arrayOne[j];
                } else if (i == 1) {
                    twoDimArray[i][j] = arrayTwo[j];
                }
            }
        }
        System.out.println("twoDimArray is");
        for (int i=0;i< twoDimArray.length;i++) {
            System.out.println(Arrays.toString(twoDimArray[i]));
        }
    }
}
