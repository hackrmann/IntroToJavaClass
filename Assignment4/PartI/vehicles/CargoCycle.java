package vehicles;

public class CargoCycle extends Bicycle {
    public CargoCycle(int numberOfWheels, int cargoSpace, String color) {
        super(numberOfWheels, cargoSpace, color);
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        CargoCycle cargoCycle = (CargoCycle) o;
        return super.equals(cargoCycle);
    }

    public String toString() {
        String s = "Cargo cycle:\n\t" + super.toString();
        return s;
    }

}
