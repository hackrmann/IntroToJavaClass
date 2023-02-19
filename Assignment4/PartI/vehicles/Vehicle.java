package vehicles;

public class Vehicle {
    private int numberOfWheels;
    private float cargoSpace;       //Assume in litres

    private String color;

    private static int id = 0;

    public Vehicle() {
        this(2,0);
    }
    public Vehicle(int numberOfWheels, float cargoSpace) {
        this.numberOfWheels = numberOfWheels;
        this.cargoSpace = cargoSpace;
        ++id;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public float getCargoSpace() {
        return cargoSpace;
    }

    public void setCargoSpace(float cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        String s = "Vehicle:\n";
        s = s + "\tNumber of Wheels: " + numberOfWheels;
        s = s + "\tCargo Space: " + cargoSpace;
        s = s + "\tColor: " + color;
        s = s + "\tID: " + id;
        return s;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        Vehicle vehicle = (Vehicle) o;
        if(this.numberOfWheels == vehicle.getNumberOfWheels())
            if(this.cargoSpace == vehicle.getCargoSpace())
                if(this.color.equals(vehicle.getColor()))
                    return true;
        return false;
    }
}
