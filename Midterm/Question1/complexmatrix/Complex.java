package complexmatrix;

import complexmatrix.exceptions.NotAComplexNumberException;

public class Complex implements Comparable {

    public double a;
    public double b;

    public Complex() {

    }

    public Complex(double a) {

    }

    public Complex(double a, double b) {

    }

    public double getReal() {
        return this.a;
    }

    public void setReal(double a) {
        this.a = a;
    }

    public double getImaginary() {
        return this.b;
    }

    public void setImaginary(double b) {
        this.b = b;
    }

    public String toString() {
        String signOfImaginary = "+";
        if (this.b < 0)
            signOfImaginary = "-";
        return this.a + " " + signOfImaginary + " i" + this.b;
    }

    public double getMagnitude() {
        return Math.sqrt(this.a * this.a + this.b * this.b);
    }

    public Complex add(Complex c) {
        return new Complex(c.getReal() + this.a, c.getImaginary() + this.b);
    }

    public Complex subtract(Complex c) {
        return new Complex(this.a - c.getReal(), this.b - c.getImaginary());
    }

    public Complex multiply(Complex c) {
        return new Complex(this.a * c.getReal() - this.b * c.getImaginary(),
                this.a * c.getImaginary() + this.b * c.getReal());
    }

    public Complex divide(Complex c) {
        Complex result = new Complex();
        double denom = c.getReal() * c.getReal() + c.getImaginary() * c.getImaginary();
        result.setReal((this.a * c.getReal() + this.b * c.getImaginary()) / denom);
        result.setImaginary((this.b * c.getReal() - this.a * c.getImaginary()) / denom);
        return result;
    }

    @Override
    public int compareTo(Object object) throws NotAComplexNumberException {
        if (!(object instanceof Complex))
            throw new NotAComplexNumberException("Object passed is not of type Complex");
        double this_mag = getMagnitude(), c_mag = ((Complex) object).getMagnitude();
        return Double.compare(this_mag, c_mag);
    }
}
