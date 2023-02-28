package vehicles;

import vehicles.exceptions.VehicleException;

public class CargoCycle extends Bicycle {

    public CargoCycle() throws VehicleException {
        super();
    }
    public CargoCycle(int numberOfWheels, int cargoSpace, String color) throws VehicleException {
        super(numberOfWheels, cargoSpace, color);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof CargoCycle)) return false;
        CargoCycle cargoCycle = (CargoCycle) o;
        return super.equals(cargoCycle);
    }

    public String toString() {
        String s = "Cargo cycle:\n\t" + super.toString();
        return s;
    }

}
