package vehicles;

import java.util.Objects;

public class Bicycle extends Vehicle {

    private String type;

    public Bicycle(String color) {
        super(2, 0, color);
        type = "electric";
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof Bicycle)) return false;
        Bicycle bicycle = (Bicycle) o;
        return (this.type == bicycle.getType()) ? super.equals(o) : false;
    }

    Bicycle(int numberOfWheels, int cargoSpace, String color) {
        super(numberOfWheels, cargoSpace, color);
        type = "electric";
        if (!(this instanceof CargoCycle)) {
            System.out.println("Bicycles can only have 2 wheels and no cargo space!");
            super.setNumberOfWheels(2);
            super.setCargoSpace(0);
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
        return s;
    }
}