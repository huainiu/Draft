package UnitTesting.Mocking;

import java.io.InputStream;

/**
 * Created by Michael.Shreiber on 3/23/14.
 */
public class MockConnectionFactory implements ConnectionFactory {
    private InputStream inputStream;

    public void setData(InputStream stream) {
        this.inputStream = stream;
    }

    public InputStream getData() throws Exception {
        return this.inputStream;
    }
}