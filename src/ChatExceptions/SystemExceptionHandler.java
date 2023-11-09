package ChatExceptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class SystemExceptionHandler {

    // Create an instance of the CustomExceptionHandler class
    //Collaborator => Abinet Tamiru
    LocalDateTime localDateTime = LocalDateTime.now();
    CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();

    /**
     * Writes the stack trace of an exception to a log file, along with a timestamp, for system logging purposes.
     *
     * @param thr The exception for which the stack trace is to be logged.
     */
    //Collaborator => Abinet Tamiru
    public void writeSystemLog(Throwable thr) {
        BufferedWriter writer;

            try {
                writer = new BufferedWriter(new FileWriter("System.log",true));
                String stackTrace = getStackTrace(thr);
                String timeStamp = "error timeStamp = " + localDateTime;
                writer.write(timeStamp + "\n" + stackTrace + "\n");
                writer.newLine();
                writer.close();

            } catch (IOException e) {
                // If an exception occurs while writing to the log file, handle it using the custom exception handler
                //Collaborator => Abinet Tamiru
                customExceptionHandler.handleException(e);
            }

    }

    /**
     * Retrieves the stack trace of a Throwable object as a formatted string representation,
     * including the original exception and any nested causes.
     *
     * @param thr The Throwable object for which the stack trace is to be retrieved.
     * @return A string representation of the stack trace.
     */
    //Collaborator => Abinet Tamiru

    private String getStackTrace(Throwable thr) {
        StringBuilder sb = new StringBuilder();
        sb.append(thr.toString()).append("\n");

        StackTraceElement[] stackTrace = thr.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            sb.append("\tat ").append(element.toString()).append("\n");
        }
        Throwable cause = thr.getCause();
        if (cause != null) {
            sb.append("Caused by: ").append(getStackTrace(cause));
        }

        return sb.toString();
    }

}
