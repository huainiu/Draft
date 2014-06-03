package DesignPatternsNotes.Command;

/**
 * Created by Michael.Shreiber on 2/23/14.
 */
public class Light {
    String name;
    public Light(String name){
        this.name = name;
    }

    public void on(){
        System.out.println(this.toString() + " light is ON");
    }

    public void off(){
        System.out.println(this.toString() + " light is OFF");
    }

    @Override
    public String toString(){
        return this.name;
    }
}
