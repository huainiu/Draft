package DesignPatternsNotes.Command;

/**
 * Created by Michael.Shreiber on 2/23/14.
 */
public class GarageDoor {

    String name;
    public GarageDoor(String name){
        this.name = name;
    }

    public void open(){
        System.out.println("Garage door is opened.");
    }

    public void close(){
        System.out.println("Garage door is closed.");
    }

    @Override
    public String toString(){
        return this.name;
    }
}
