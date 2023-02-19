package vehicles;

import java.util.Arrays;

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
        return (helpCompare(this.accessories, motorcycle.accessories)) ? super.equals(o) : false;
    }

    public boolean helpCompare(String[] s1, String[] s2) {
        if (s1.length != s2.length) return false;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) return false;
        }
        return true;
    }
}
