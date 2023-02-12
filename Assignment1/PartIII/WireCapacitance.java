class WireCapacitance {
    public static void main(String[] arguments) {
        double absolutePermittivity = 8.85E-12;
        double initialDistance = .01;
        double finalDistance = .005;
        double wireLength = 0.5;
        double wireRadius = .002053;
        double capacitanceDifference = 0;

        double distanceByTwiceRadius = Math.abs(initialDistance - finalDistance) / (2 * wireRadius);
        capacitanceDifference = (Math.PI * absolutePermittivity * wireLength) /
                Math.log(distanceByTwiceRadius + Math.sqrt(distanceByTwiceRadius * distanceByTwiceRadius - 1));
        System.out.println("The wires' change in capacity when moved from a distance of "
                + +initialDistance +
                " m to " + finalDistance + "m is " + capacitanceDifference + " farads");
    }
}