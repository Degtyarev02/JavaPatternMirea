package com.company.EX7.facade;

/**
 * todo Document type CarEngineFacade
 */
public class CarEngineFacade {
    public static final int MIN_TEMP = 50;
    public static final int MAX_TEMP = 90;

    public static void startEngine(){
        System.out.println("Зажигание..");
        AirFlowController.getAir();
        CoolingController.getEngineTemp(MIN_TEMP);
        FuelInjector.getFuel();
        Starter.start();
        System.out.println("Мотор завелся, приятной поездки!");
    }

    public static void stopEngine(){
        AirFlowController.stopAir();
        CoolingController.getEngineTemp(MAX_TEMP);
        FuelInjector.stopFuel();
        System.out.println("Мотор заглушен");
    }
}
