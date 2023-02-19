package vehicles;

public class Motorcycle extends Vehicle {
    private String[] accessories;

    public String TwistThrottle() {
        return "accelerating";
    }

    public String[] getAccessories() {
        return accessories;
    }

    public void setAccessories(String[] accessories) {
        this.accessories = accessories;
    }

    public String toString() {
        String s = "Motorcycle:\n\t" + super.toString() + "\n";
        s = s + "\tAccessories: " + accessories.toString();
        return s;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        Motorcycle motorcycle = (Motorcycle) o;
        return (this.accessories == motorcycle.getAccessories()) ? super.equals(o) : false;
    }
}
