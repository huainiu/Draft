package DesignPatternsNotes.Command;

/**
 * Created by Michael.Shreiber on 2/23/14.
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Empty slot");
    }
}
