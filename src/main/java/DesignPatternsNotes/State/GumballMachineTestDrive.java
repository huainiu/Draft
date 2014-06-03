package DesignPatternsNotes.State;

/**
 * Created by Michael.Shreiber on 3/12/14.
 */
public class GumballMachineTestDrive {

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        int i = 10;
        while (i > 0) {
            System.out.println(gumballMachine);
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
            i--;
        }

    }
}