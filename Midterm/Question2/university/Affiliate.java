package university;

public class Affiliate extends Person {
    public Affiliate(int age) {
        super(age);
    }
    public String toString() {
        return "Type: " + this.getClass().getSimpleName() + "\n" + super.toString();
    }
    public boolean equals(Object object) {
        if(!(object instanceof Affiliate))
            return false;
        return super.equals((Affiliate)object);
    }
}
