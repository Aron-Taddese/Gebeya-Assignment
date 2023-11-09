package ChatExceptions;

public class CustomExceptionHandler {
    public void handleException(Throwable e) {
    System.out.println("CustomException Handler ` "+ e.getMessage()+" `");
    }

}
