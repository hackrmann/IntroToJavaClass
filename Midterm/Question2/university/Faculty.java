package university;

public class Faculty extends Employee {
    boolean tenureTrack;

    private String department;

    public Faculty(int age, int salary, boolean tenureTrack, String department) {
        super(age, salary);
        this.tenureTrack = tenureTrack;
        this.department = department;
    }

    public String toString() {
        String s = "Type: " + this.getClass().getSimpleName() + "\n" +
                "Tenured: " + (tenureTrack ? "Yes" : "No") + "\n" +
                "Department: " + this.department + "\n" + super.toString();
        return s;
    }
    public boolean equals(Object object) {
        if(!(object instanceof Faculty))
            return false;
        Faculty faculty = (Faculty) object;
        if(faculty.tenureTrack == this.tenureTrack && faculty.department.equals(this.department))
            return super.equals(faculty);
        return false;
    }
}
