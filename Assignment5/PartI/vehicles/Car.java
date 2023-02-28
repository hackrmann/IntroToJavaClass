package vehicles;

import vehicles.exceptions.VehicleException;

public class Car extends Vehicle {
    int numberOfDoors;

    public Car() throws VehicleException {
        super(4,0,"");
        this.numberOfDoors = 4;
    }
    public Car(int cargoSpace, int numberOfDoors, String color) throws VehicleException {
        super(4, cargoSpace, color);
        if(numberOfDoors < 2)
            throw new VehicleException("Cars cannot have fewer than 2 doors!");
        if (!(numberOfDoors == 2 || numberOfDoors == 4)) {
            throw new VehicleException("Cars must have only 2 or 4 doors!");
        }
        this.numberOfDoors = numberOfDoors;
    }

    public String PressGasPedal() {
        return "accelerating";
    }

    public String toString() {
        String s = "Car:\n\t" + super.toString() + "\n";
        s = s + "\tNumber of doors: " + numberOfDoors;
        s += "\n";
        return s;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof Car)) return false;
        Car car = (Car) o;
        return (this.numberOfDoors == car.getNumberOfDoors()) ? super.equals(o) : false;
    }
}
