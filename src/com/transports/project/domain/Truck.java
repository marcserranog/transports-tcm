package com.transports.project.domain;

import com.transports.project.utilities.ConstantUtilities;

public class Truck {

    private String id;
    private int capacity;
    private double actualGas = ConstantUtilities.MAX_DEPOSIT;
    private double temperature = ConstantUtilities.FOOD_TEMPERATURE;

    private int drivingTime = 0;
    private int kmsTraveled = 0;
    private int rechargedGas = 0;
    private int currentTemperature = 0;


    public Truck() {
    }

    public Truck(int capacity) throws Exception {

        if(capacity>0.30*ConstantUtilities.MAX_CAPACITY){
            this.capacity = capacity;
        }
        else{
            throw new Exception("Maxium capacity reached.");
        }
    }

    public String getId() {
        return id;
    }
    public int getCapacity() {
        return capacity;
    }
    public double getActualGas() {
        return actualGas;
    }
    public double getTemperature() {
        return temperature;
    }
    public int getCurrentTemperature() {
        return currentTemperature;
    }
    public int getDrivingTime() {
        return drivingTime;
    }
    public int getKmsTraveled() {
        return kmsTraveled;
    }
    public int getRechargedGas() {
        return rechargedGas;
    }

    public double miniumLoading() {
        return this.capacity * 0.30;
    }

    public void makeRoute(int kms) throws Exception {
        this.rechargedGas = (kms / ConstantUtilities.VELOCITY) * ConstantUtilities.CONSUME;
        int time = (kms / ConstantUtilities.VELOCITY);
        this.currentTemperature =((ConstantUtilities.FOOD_TEMPERATURE + ConstantUtilities.INCREASE_TEMPERATURE) * time);

        this.temperature = this.temperature - this.currentTemperature;
        this.actualGas = this.actualGas - this.rechargedGas;

        if (this.temperature > ConstantUtilities.MAX_TEMPERATURE)
            throw new Exception("Has exceeded the temperature.");
        else if (this.actualGas > ConstantUtilities.MAX_DEPOSIT)
            throw new Exception("Has exceeded the fuel tank.");
    }

    public void fillTank() {
        this.actualGas = ConstantUtilities.MAX_DEPOSIT;
    }

    public double finalPriceDriver() {
        drivingTime= kmsTraveled / ConstantUtilities.VELOCITY;
        return ConstantUtilities.DRIVER_PRICE_PER_HOUR * drivingTime;
    }

    public double finalPriceGas() {
        return ConstantUtilities.GAS_PRICE * rechargedGas;
    }
    //TODO falta el consum de stops i el temps que esta el tiu parat cada cop que fas una parada el tiu consumeix.
}
