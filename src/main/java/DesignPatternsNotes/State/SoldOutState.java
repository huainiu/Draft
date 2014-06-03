package DesignPatternsNotes.State;

/**
 * Created by Michael.Shreiber on 3/12/14.
 */
public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("Sorry, all gumballs are sold out.");
    }

    public void ejectQuarter() {
        System.out.println("You haven’t inserted a quarter");
    }

    public void turnCrank() {
        System.out.println("You turned, but there’s no quarter");
    }

    public void dispense() {
        System.out.println("You need to pay first");
    }
}
