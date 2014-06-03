package UnitTesting.Controller;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The  @Before and  @After annotated methods are executed right before/after the
 * execution of each one of your  @Misc.Test methods, and regardless of the fact whether the
 * test failed or not. This helps you to extract all of your common logic, like instantiating
 * your domain objects and setting them up in some known state. You can have as many of
 * these methods, as you want, but beware because in case you have more than one of the
 *
 * @Before/@After methods no one knows what is the order of their execution.
 * JUnit also provides the  @BeforeClass and  @AfterClass annotations to annotate
 * your methods in that class. The methods that you annotate will get executed, only once
 * before/after all of your  @Misc.Test methods. Again, as with the  @Before and  @After
 * annotations you can have as many of these methods as you want, and again nothing is
 * specified about the order of the execution.
 * You  need  to  remember  that  both  the  @Before/@After and
 * @BeforeClass/@AfterClass annotated methods must be  public by signature.
 * The  @BeforeClass/@AfterClass annotated methods must be  public and also be
 * static by signature.
 * <p/>
 * <p/>
 * Created by Michael.Shreiber on 3/13/14.
 */
public class TestDefaultController {
    private DefaultController controller;
    private Request request;
    private RequestHandler handler;

    private class SampleRequest implements Request {
        private static final String DEFAULT_NAME = "Misc.Test";
        private String name;

        public SampleRequest(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    private class SampleHandler implements RequestHandler {
        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    private class SampleResponse implements Response {
// empty
    }

    @Before
    @Ignore ("experimantal project only for learning purposes.")
    public void instantiate() throws Exception {
        controller = new DefaultController();
        request = new SampleRequest("testNotDefined");
        handler = new SampleHandler();
        controller.addHandler(request, handler);
    }

    @Test
    @Ignore ("experimantal project only for learning purposes.")
    public void testAddHandler() {
        RequestHandler handler2 = controller.getHandler(request);
        assertSame("Handler we set in controller should be the same handler we get", handler2, handler);
    }

    @Test
    @Ignore ("experimantal project only for learning purposes.")
    public void testProcessRequest() {
        Response response = controller.processRequest(request);
        assertNotNull("Must not return a null response", response);
        assertEquals("Response should be of type SampleResponse", SampleResponse.class, response.getClass());
    }


    //Testing exceptions.
    @Test(expected = RuntimeException.class)
    @Ignore(value = "don't need to test exceptions at this point.")
    public void testGetHandlerNotDefined() {
        SampleRequest request = new SampleRequest("testNotDefined");
        //The following line is supposed to throw a RuntimeException
        controller.getHandler(request);
    }

    @Test(expected = RuntimeException.class)
    @Ignore(value = "don't need to test exceptions at this point.")
    public void testAddRequestDuplicateName() {
        SampleRequest request = new SampleRequest("testNotDefined2");
        SampleHandler handler = new SampleHandler();
        // The following line is supposed to throw a RuntimeException
        controller.addHandler(request, handler);
    }

    @Test(timeout = 120)
    @Ignore ("experimantal project only for learning purposes.")
    public void testProcessMultipleRequestsTimeout() {
        Request request;
        Response response = new SampleResponse();
        RequestHandler handler = new SampleHandler();
        for (int i = 0; i < 99999; i++) {
            request = new SampleRequest(String.valueOf(i));
            controller.addHandler(request, handler);
            response = controller.processRequest(request);
            assertNotNull(response);
            assertNotSame(ErrorResponse.class, response.getClass());
        }
    }


}
