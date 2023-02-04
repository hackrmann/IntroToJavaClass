
public class WireCapacitance {

    public static double calculateWireCapacitance(double wireLength, double wireRadius, double initialDistance, double finalDistance) {
        double absolutePermittivity = 8.85E-12;
        double distanceByTwiceRadius = Math.abs(initialDistance - finalDistance) / (2 * wireRadius);
        return (Math.PI * absolutePermittivity * wireLength) /
                Math.log(distanceByTwiceRadius + Math.sqrt(distanceByTwiceRadius * distanceByTwiceRadius - 1));
    }

    public static void main(String[] args) {
        double wireCapacitance = calculateWireCapacitance(0.5, 0.002053, 0.01, 0.005);
        System.out.println("The wire capacitance calculated from the function is " + wireCapacitance);
    }
}
