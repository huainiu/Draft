package DesignPatternsNotes.Observer;

/**
 * Created by Michael.Shreiber on 2/9/14.
 */
public interface Subject {

    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();


}
