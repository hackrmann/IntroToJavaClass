package university;

public class GraduateStudent extends Student {
    boolean isPhD;

    public GraduateStudent(int age, String department, boolean isPhD) {
        super(age, department);
        this.isPhD = isPhD;
    }

    public String toString() {
        String s = "Type: " + this.getClass().getSimpleName() + "\n" +
                "Graduate type: " + (isPhD ? "PhD " : "Masters") + "Student \n"
                + super.toString();
        return s;
    }
    public boolean equals(Object object) {
        if(!(object instanceof GraduateStudent))
            return false;
        GraduateStudent graduateStudent = (GraduateStudent) object;
        if(graduateStudent.isPhD == this.isPhD)
            return super.equals(graduateStudent);
        return false;
    }
}
