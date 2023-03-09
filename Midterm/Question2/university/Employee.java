package university;

public abstract class Employee extends Person {
    public int salary;

    public Employee(int age, int salary) {
        super(age);
        this.salary = salary;
    }

    public String toString() {
        String s = "Salary: " + this.salary + "\n" + super.toString();
        return s;
    }

    public boolean equals(Object o) {
        if (this.salary == ((Employee) o).salary)
            return super.equals((Employee) o);
        return false;
    }
}
