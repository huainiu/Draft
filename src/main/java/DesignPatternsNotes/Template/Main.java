package DesignPatternsNotes.Template;

/**
 * Created by Michael.Shreiber on 3/3/14.
 */
public class Main {
    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.prepareRecipe();

        Coffee coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
