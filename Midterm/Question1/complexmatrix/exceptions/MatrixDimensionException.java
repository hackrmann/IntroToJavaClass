package complexmatrix.exceptions;

public class MatrixDimensionException extends Exception {
    private String errorMessage;

    public MatrixDimensionException(String s) {
        this.errorMessage = s;
        System.err.println(errorMessage);
    }
}
