package com.example.projectegrupalxavineta.application.dtos;

import com.example.projectegrupalxavineta.domain.Truck;

import java.security.InvalidParameterException;

public class TruckDTO {

    private String id;
    private int capacity;
    private double actualGas;
    private double temperature;
    private int drivingTime;

    private int kmsTraveled;
    private int rechargedGas;

    public TruckDTO() {
    }

    public TruckDTO(String id, int capacity, double actualGas,
                    double temperature, int drivingTime,
                    int kmsTraveled, int rechargedGas) {
        this.id = id;
        this.capacity = capacity;
        this.actualGas = actualGas;
        this.temperature = temperature;
        this.drivingTime = drivingTime;
        this.kmsTraveled = kmsTraveled;
        this.rechargedGas = rechargedGas;
    }

    public TruckDTO(Truck truck) throws InvalidParameterException {
        if (truck == null) throw new InvalidParameterException("Invalid TRUCK");

        this.id = truck.getId();
        this.capacity = truck.getCapacity();
        this.actualGas = truck.getActualGas();
        this.temperature = truck.getCurrentTemperature();
        this.drivingTime = truck.getDrivingTime();
        this.kmsTraveled = truck.getKmsTraveled();
        this.rechargedGas = truck.getConsumedGas();
    }

    public String getId() throws InvalidParameterException{
        if (id.equals("")) throw new InvalidParameterException("Invalid id");
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

    public int getDrivingTime() {
        return drivingTime;
    }

    public int getKmsTraveled() {
        return kmsTraveled;
    }

    public int getRechargedGas() {
        return rechargedGas;
    }
}
