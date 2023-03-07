package complexmatrix.exceptions;

public class NotAComplexNumberException extends RuntimeException{
    String errorMessage;

    public NotAComplexNumberException(String errorMessage) {
        this.errorMessage = errorMessage;
        System.err.println("Error! "+errorMessage);
    }
}
