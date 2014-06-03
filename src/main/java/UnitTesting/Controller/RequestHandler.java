package UnitTesting.Controller;

/**
 * Created by Michael.Shreiber on 3/13/14.
 */
public interface RequestHandler {
        Response process(Request request) throws Exception;
}
