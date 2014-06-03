package DesignPatternsNotes.Observer;

/**
 * Created by Michael.Shreiber on 2/9/14.
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData wd = new WeatherData();
        CurrentConditionsDisplay current = new CurrentConditionsDisplay(wd);

        wd.setMeasurements(15, 60, 70);
        wd.setMeasurements(5, 100, 30);
        wd.setMeasurements(0, 120, 90);
        wd.setMeasurements(-25, 0, 170);
        wd.setMeasurements(25, 90, 0);
    }
}
