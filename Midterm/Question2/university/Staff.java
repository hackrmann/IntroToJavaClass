package university;

public class Staff extends Employee {
    public Staff(int age, int salary) {
        super(age, salary);
    }

    public String toString() {
        return "Type: " + this.getClass().getSimpleName() + "\n" + super.toString();
    }

    public boolean equals(Object object) {
        if (!(object instanceof Staff))
            return false;
        Staff staff = (Staff) object;
        return super.equals(staff);
    }
}
