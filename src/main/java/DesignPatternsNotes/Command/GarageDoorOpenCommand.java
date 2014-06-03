package DesignPatternsNotes.Command;

/**
 * Created by Michael.Shreiber on 2/23/14.
 */
public class GarageDoorOpenCommand implements Command {
    GarageDoor door;
    public GarageDoorOpenCommand(GarageDoor door){
        this.door = door;
    }

    @Override
    public void execute() {
        door.open();
    }
}
