package com.example.projectegrupalxavineta.utilities;

public class ConstantUtilities {

    public static final int BARCELONA = 0;
    public static final int VIGO = 1;
    public static final int SEVILLA = 2;
    public static final int VALENCIA = 3;
    public static final int MADRID = 4;

    public static final double MAX_DEPOSIT = 150;
    public static final int MAX_CAPACITY=200;
    public static final double MAX_TEMPERATURE = 0;
    public static final double GAS_PRICE = 2;
    public static final double DRIVER_PRICE_PER_HOUR = 15;
    public static final int VELOCITY = 100;
    public static final int FOOD_TEMPERATURE = -20;
    public static final int CONSUME = 20;
    public static final int INCREASE_TEMPERATURE =3;
    public static final double MAXIM_KMS = calculateKilometresMaximum();
    public static final int WAITING_PERIOD = 5;

    public static double calculateKilometresMaximum() {
        return -(FOOD_TEMPERATURE/INCREASE_TEMPERATURE)*VELOCITY;
    }

}
