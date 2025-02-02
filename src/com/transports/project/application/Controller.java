package com.transports.project.application;

import com.transports.project.application.dtos.RouteDTO;
import com.transports.project.application.dtos.StoreDTO;
import com.transports.project.application.dtos.TruckDTO;
import com.transports.project.domain.Route;
import com.transports.project.domain.Store;
import com.transports.project.domain.Truck;

import java.util.Random;

public class Controller {
    public Controller() {
    }
    public RouteDTO createTruckRoute(int id,String initialStore, String finalStore, Truck truck) throws Exception {
        return createRouteDTO(id,createStore(initialStore),createStore(finalStore),truck);
    }
    public StoreDTO createStoreDTO(String location) throws Exception {
        return new StoreDTO(createStore(location));
    }
    private Store createStore(String location){
        return new Store(location);
    }
    public RouteDTO createRouteDTO(int id, Store initialStore,Store finalStore, Truck truck) throws Exception {
        return new RouteDTO(createRoute(id,initialStore,finalStore,truck));
    }
    private Route createRoute(int id, Store initialStore,Store finalStore, Truck truck) throws Exception {
        return new Route(id,initialStore,finalStore,truck);
    }
    public void moveTruck(){
        moveTruck();
    }

    private Truck createTruck(int capacity) throws Exception{
        return new Truck(capacity);
    }
    public TruckDTO createTruckDTO(int capacity) throws Exception {
        return new TruckDTO(createTruck(capacity));
    }



}
