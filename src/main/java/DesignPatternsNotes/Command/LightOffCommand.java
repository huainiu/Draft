package DesignPatternsNotes.Command;

/**
 * Created by Michael.Shreiber on 2/23/14.
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
