package complexmatrix.exceptions;

public class IncompatibleMatrixException extends Exception {
    private String errorMessage;

    public IncompatibleMatrixException(String s) {
        this.errorMessage = s;
    }
    public String toString() {
        System.err.println(this.errorMessage);
        return this.errorMessage;
    }
}
