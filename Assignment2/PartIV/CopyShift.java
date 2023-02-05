
public class CopyShift {

    public static void printArray(int[] array) {
        int i;
        System.out.print("[");
        for (i = 0; i < array.length - 1; i++)
            System.out.print(array[i] + ", ");
        System.out.print(array[i] + "]");
    }
    public static void printArrays(int[] a, int[] b) {
        System.out.print("Source array:\t\t ");
        printArray(a);
        System.out.print("\nDestination array:\t ");
        printArray(b);
    }

    public static void copyShift(int[] sourceArray, int[] destArray, int shift) {
        shift = (shift % sourceArray.length + sourceArray.length) % sourceArray.length;
        int justBeforeShift = (shift - 1 + sourceArray.length) % sourceArray.length;

        for (int i = shift; i != justBeforeShift; i = (i + 1) % sourceArray.length)
            destArray[i] = sourceArray[(i - shift + sourceArray.length) % sourceArray.length];
        destArray[justBeforeShift] = sourceArray[sourceArray.length - 1];

        printArrays(sourceArray, destArray);
    }

    public static void main(String[] args) {

        int[] sourceArray = new int[50];
        int[] destArray = new int[50];

        /* initialize the source Array */
        for (int i = 0; i < sourceArray.length; i++) {
            sourceArray[i] = (int) (Math.random() * 100);
        }

        int shiftValue = 5;
        copyShift(sourceArray, destArray, shiftValue);

        /* destArray should have the contents of sourceArray
         * but in shifted over "shiftValue" values
         * if sourceArray has the contents [1,5,6,7,9] and we want to shift it
         * 3 spaces over, destArray should have the contents [6,7,9,1,5].
         *
         * It should work for arbitrarily large values of shift
         */
    }
}
