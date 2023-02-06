
public class LoopSum {

    public static double estimateExponential(int z, double expActualValue) {
        double result = 1, diff=0, fact = 1;
        int k = 1;
        while (Math.abs(expActualValue - result) > 0.001) {
            result += (Math.pow(z, k) / fact);
            fact = (++k) * fact;
            diff = Math.abs(expActualValue - result);
        }
        System.out.println("result for " + k + " iterations: " + result+diff);
        return k;
    }

    public static void main(String[] args) {
//		System.out.println("e^2 " + Math.pow(Math.E, 2));
        double delta = 0.001, expActualValue = 0;
        int iterations = 0;
        for (int z = 0; z < 16; z++) {
            expActualValue = Math.pow(Math.E, z);
            System.out.println("e^" + z + " is " + expActualValue);

            iterations = (int) estimateExponential(z, expActualValue);
            System.out.println("it requires " + iterations + " iterations to estimate e^" + z + " within " + delta);
            System.out.println("----------");
        }

    }

}
