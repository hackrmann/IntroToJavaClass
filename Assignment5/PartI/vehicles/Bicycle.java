package vehicles;

import vehicles.exceptions.VehicleException;

import java.util.Objects;

public class Bicycle extends Vehicle {

    private String type;

    public Bicycle() throws VehicleException {
        super();
        type = "electric";
    }

    public Bicycle(String color) throws VehicleException {
        this();
        super.setColor(color);
        type = "electric";
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof Bicycle)) return false;
        Bicycle bicycle = (Bicycle) o;
        return (this.type == bicycle.getType()) ? super.equals(o) : false;
    }

    Bicycle(int numberOfWheels, int cargoSpace, String color) throws VehicleException {
        super(numberOfWheels, cargoSpace, color);
        type = "electric";
        if (!(this instanceof CargoCycle)) {
            throw new VehicleException("Bicycles can only have 2 wheels and no cargo space!");
        }
    }


    public String Pedal() {
        return "pedaling";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        String s = "Bicycle:\n\t" + super.toString() + "\n";
        s = s + "\tType: " + type;
        s += "\n";
        return s;
    }
}
