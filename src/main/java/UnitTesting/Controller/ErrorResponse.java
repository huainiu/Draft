package UnitTesting.Controller;

import javax.xml.ws.*;
import java.sql.ResultSet;

/**
 * Created by Michael.Shreiber on 3/13/14.
 */
public class ErrorResponse implements Response {
    private Request originalRequest;
    private Exception originalException;

    public ErrorResponse(Request request, Exception exception) {
        this.originalRequest = request;
        this.originalException = exception;
    }

    public Request getOriginalRequest() {
        return this.originalRequest;
    }

    public Exception getOriginalException() {
        return this.originalException;
    }
}
