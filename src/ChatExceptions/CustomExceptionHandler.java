package ChatExceptions;

public class CustomExceptionHandler {
    /**
     * Handles an exception by printing a custom message containing the exception's message to the console.
     *
     * @param e The Throwable object representing the exception to be handled.
     */
    //Collaborator => Abinet Tamiru
    public void handleException(Throwable e) {
    System.out.println("CustomException Handler ` "+ e.getMessage()+" `");
    }

}
