package DesignPatternsNotes.State;

/**
 * Created by Michael.Shreiber on 3/12/14.
 */
public interface State {

    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();

}
