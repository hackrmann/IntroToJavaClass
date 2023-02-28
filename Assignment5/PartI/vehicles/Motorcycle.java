package vehicles;

import java.lang.module.ModuleReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Motorcycle extends Vehicle {
    private String[] accessories;

    public Motorcycle(String[] accessories, String color) {
        super(2, 0, color);
        this.accessories = accessories;
    }

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
        s = s + "\tAccessories: " + printAccessories();
        return s;
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof Motorcycle)) return false;
        Motorcycle motorcycle = (Motorcycle) o;
        return (helpCompare(this.accessories, motorcycle.accessories)) ? super.equals(o) : false;
    }

    //Handles both case sensitivity and different order of strings
    public boolean helpCompare(String[] s1, String[] s2) {
        if (s1.length != s2.length) return false;
        String[] upperCaseS1 = new String[s1.length];
        String[] upperCaseS2 = new String[s2.length];
        for (int i = 0; i < s1.length; i++) {
            upperCaseS1[i] = s1[i].toUpperCase();
            upperCaseS2[i] = s2[i].toUpperCase();
        }
        List<String> l1 = new ArrayList<String>(Arrays.asList(upperCaseS1));
        List<String> l2 = new ArrayList<String>(Arrays.asList(upperCaseS2));
        Collections.sort(l1);
        Collections.sort(l2);
        return l1.equals(l2);
    }

    public String printAccessories() {
        String s = "[";
        for (int i = 0; i < this.accessories.length - 1; i++) {
            s += this.accessories[i] + ", ";
        }
        s += this.accessories[this.accessories.length - 1] + "]";
        return s;
    }
}
