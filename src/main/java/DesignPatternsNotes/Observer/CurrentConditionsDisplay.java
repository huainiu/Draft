package DesignPatternsNotes.Observer;

/**
 * Created by Michael.Shreiber on 2/9/14.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject s){
        this.weatherData = s;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        dispaly();
    }

    @Override
    public void dispaly() {
        System.out.println("Current conditions:");
        System.out.println("Temperature: " + this.temperature + " C");
        System.out.println("Humidity: " + this.humidity + " %");
        System.out.println("*********************************************************");
        System.out.println();
    }
}
