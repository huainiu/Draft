package DesignPatternsNotes.Observer;

/**
 * Created by Michael.Shreiber on 2/9/14.
 */
public interface Observer {

    public void update(float temp, float humidity, float pressure);
}
