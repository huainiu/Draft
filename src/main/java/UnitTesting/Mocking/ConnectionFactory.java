package UnitTesting.Mocking;

import java.io.InputStream;

/**
 * Created by Michael.Shreiber on 3/23/14.
 */


public interface ConnectionFactory {
    InputStream getData() throws Exception;
}