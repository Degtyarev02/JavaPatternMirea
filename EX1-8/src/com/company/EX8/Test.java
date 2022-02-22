package com.company.EX8;

import com.company.EX8.observer.CurrentConditionsDisplay;
import com.company.EX8.observer.Observer;
import com.company.EX8.observer.WeatherData;
import com.company.EX8.state.StateContext;


/**
 * todo Document type Test
 */
public class Test {
    public static void main(String[] args) {
        observerPattern();
        statePattern();
    }

    public static void observerPattern(){
        System.out.println("===========Observer pattern===========");
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay = new CurrentConditionsDisplay();
        Observer currentDisplay2 = new CurrentConditionsDisplay();

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(currentDisplay2);

        weatherData.setMeasurements(29f, 65f, 745);
        weatherData.setMeasurements(39f, 70f, 760);
        weatherData.setMeasurements(42f, 72f, 763);
    }

    public static void statePattern(){
        System.out.println("===========State pattern===========");
        StateContext context = new StateContext();
        context.heat();
        context.heat();
        context.heat();
        context.freeze();
        context.freeze();
        context.freeze();
    }
}
