package university;

public class Undergraduate extends Student {
    private boolean isMatriculated;

    public Undergraduate(int age, String department, boolean isMatriculated) {
        super(age, department);
        this.isMatriculated = isMatriculated;
    }

    public String toString() {
        String s = "Type: " + this.getClass().getSimpleName() + "\n" +
                "Matriculated: " + (isMatriculated ? "Yes" : "No") + "\n" +
                super.toString();
        return s;
    }

    public boolean equals(Object object) {
        if(!(object instanceof Undergraduate))
            return false;
        Undergraduate undergraduate = (Undergraduate) object;
        if(undergraduate.isMatriculated == this.isMatriculated)
            return super.equals(undergraduate);
        return false;
    }
}
