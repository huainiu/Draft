package DesignPatternsNotes.Template;

/**
 * Created by Michael.Shreiber on 3/3/14.
 */
public class Tea extends CoffeineBeverage {
    public void brew() {
        System.out.println("Steeping the tea");
    }
    public void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
