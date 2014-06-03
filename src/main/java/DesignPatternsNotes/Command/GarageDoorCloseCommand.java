package DesignPatternsNotes.Command;

/**
 * Created by Michael.Shreiber on 2/23/14.
 */
public class GarageDoorCloseCommand implements Command {
    GarageDoor door;
    public GarageDoorCloseCommand(GarageDoor door){
        this.door = door;
    }
    @Override
    public void execute() {
        door.close();
    }
}