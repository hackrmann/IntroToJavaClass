package vehicles;

public class Car extends Vehicle {
    int numberOfDoors;

    public Car(int cargoSpace, int numberOfDoors, String color) {
        super(4, cargoSpace, color);
        if (!(numberOfDoors == 2 || numberOfDoors == 4)) {
            System.out.println("Cars can only have 2 or 4 doors, please enter a valid number of doors");
            return;
        }
        this.numberOfDoors = numberOfDoors;
    }

    public String PressGasPedal() {
        return "accelerating";
    }

    public String toString() {
        String s = "Car:\n\t" + super.toString() + "\n";
        s = s + "\tNumber of doors: " + numberOfDoors;
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
