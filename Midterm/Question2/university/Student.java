package university;

import java.util.Objects;

public abstract class Student extends Person {

    private String department;

    public Student(int age, String department) {
        super(age);
        this.department = department;
    }

    public String toString() {
        String s = "Department: " + this.department + "\n" + super.toString();
        return s;
    }

    public boolean equals(Object o) {
        if (this.department.equals(((Student) o).department))
            return super.equals((Student) o);
        return false;
    }

}
