package vehicles.exceptions;

public class VehicleException extends Exception {

    String s;
    public VehicleException(String s) {
        super("Illegal arguments while creating vehicle: " + s);
        this.s = s;
    }
    public String errorMessage() {
        return s;
    }
}
