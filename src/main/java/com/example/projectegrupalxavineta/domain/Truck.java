package com.example.projectegrupalxavineta.domain;

import com.example.projectegrupalxavineta.application.dtos.TruckDTO;
import com.example.projectegrupalxavineta.utilities.ConstantUtilities;


public class Truck {

    private String id;
    private int capacity;
    private double actualGas = ConstantUtilities.MAX_DEPOSIT;
    private double temperature = ConstantUtilities.FOOD_TEMPERATURE;

    private int drivingTime = 0;
    private int kmsTraveled = 0;
    private int consumedGas  = 0;
    private int currentTemperature = 0;


    public Truck() {
    }

    public Truck(int capacity) throws Exception {
        this.id=id;

        if(capacity>0.30*ConstantUtilities.MAX_CAPACITY){
            this.capacity = capacity;
        }
        else{
            throw new Exception("Maxium capacity reached.");
        }
    }

    public Truck(TruckDTO truckDTO) {
        
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
    public int getConsumedGas() {
        return consumedGas;
    }
    public void setDrivingTime(int drivingTime) {
        this.drivingTime = drivingTime;
    }

    public double miniumLoading() {
        return this.capacity * 0.30;
    }

    public void makeRoute(int kms) throws Exception {
        this.consumedGas = (kms / ConstantUtilities.VELOCITY) * ConstantUtilities.CONSUME;
        int time = (kms / ConstantUtilities.VELOCITY);
        this.currentTemperature =((ConstantUtilities.FOOD_TEMPERATURE + ConstantUtilities.INCREASE_TEMPERATURE) * time);

        this.temperature = this.temperature - this.currentTemperature;
        this.actualGas = this.actualGas - this.consumedGas;

        if (this.temperature > ConstantUtilities.MAX_TEMPERATURE)
            throw new Exception("Has exceeded the temperature.");
        else if (this.actualGas > ConstantUtilities.MAX_DEPOSIT) //TODO 1 >>No entenc gaire bé que vol dir en aquest if
            throw new Exception("Has exceeded the fuel tank.");
        //TODO 2 >> Falta actualitzar el driving time
    }

    public void fillTank() {
        this.actualGas = ConstantUtilities.MAX_DEPOSIT;
    }

    public double finalPriceDriver() {
        drivingTime= kmsTraveled / ConstantUtilities.VELOCITY;
        return ConstantUtilities.DRIVER_PRICE_PER_HOUR * drivingTime;
    }

    public double finalPriceGas() {
        return ConstantUtilities.GAS_PRICE * consumedGas;
    }


}
