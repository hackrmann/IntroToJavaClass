package vehicles;

public class Vehicle {
    private int numberOfWheels;
    private int cargoSpace;       //Assume in cubic feet

    private String color;

    private static int next_id = 0;

    private int id = 0;

    public Vehicle() {
        this(2, 0, "black");
    }

    public Vehicle(int numberOfWheels, int cargoSpace, String color) {
        this.numberOfWheels = numberOfWheels;
        this.cargoSpace = cargoSpace;
        this.color = color;
        this.id = ++next_id;
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

    public void setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        String s = "Vehicle:";
        s = s + "\n\t\tNumber of Wheels: " + numberOfWheels;
        s = s + "\n\t\tCargo Space: " + cargoSpace;
        s = s + "\n\t\tColor: " + color;
        s = s + "\n\t\tID: " + id;
        return s;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        Vehicle vehicle = (Vehicle) o;
        if (this.numberOfWheels == vehicle.getNumberOfWheels())
            if (this.cargoSpace == vehicle.getCargoSpace())
                if (this.color.equals(vehicle.getColor()))
                    return true;
        return false;
    }
}
