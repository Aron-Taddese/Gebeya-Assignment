package ChatExceptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class SystemExceptionHandler {
    LocalDateTime localDateTime = LocalDateTime.now();
    CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();
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
                customExceptionHandler.handleException(e);
            }

    }

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
