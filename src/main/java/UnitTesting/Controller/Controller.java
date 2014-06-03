package UnitTesting.Controller;

/**
 * Created by Michael.Shreiber on 3/13/14.
 */
public interface Controller {

    Response processRequest(Request request);
    void addHandler(Request request, RequestHandler requestHandler);
}
