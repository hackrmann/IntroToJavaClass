package vehicles;

public class CargoCycle extends Bicycle {
    public CargoCycle(int numberOfWheels, float cargoSpace) {
        super(numberOfWheels, cargoSpace);
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        CargoCycle cargoCycle = (CargoCycle) o;
        return super.equals(cargoCycle);
    }

    public String toString() {
        String s = "Cargo cycle:\n\t" + super.toString() + "\n";
        return s;
    }

}
