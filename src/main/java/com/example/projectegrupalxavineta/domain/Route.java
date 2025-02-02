package com.example.projectegrupalxavineta.domain;

import com.example.projectegrupalxavineta.utilities.ConstantUtilities;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Route {
    private String id;
    private LinkedList<Store> listStore = new LinkedList<>();  //TODO 3 >> Perque 5? S'ha de posar com a constant statica
    private int timeRoute;
    private int kmRoute;
    private int priceLoadingUnloading;
    private Truck truck;

    private List<Integer> kmsBetweenStores = new LinkedList<>();
    private int origin;
    private int destination;



    public Route( Store initialStore, Store finalStore, Truck truck) throws Exception {

        List<Store> auxiliarList = Arrays.asList(initialStore.getAllStops(finalStore));
        this.listStore = new LinkedList<>(auxiliarList) ;

        this.origin = initialStore.convertStringToInt(initialStore.getActualLocation());
        this.destination = finalStore.convertStringToInt(initialStore.getActualLocation());

        this.truck=truck;

        this.timeRoute = calculateTimeRoute(); //metode que retorni temps
        this.kmRoute = calculateTimeRoute(); //metode que retorni els km totals
        this.priceLoadingUnloading = calculatePriceCID(); //metode que calculi el preu CID
        //Generar totes les parades, recorre cada parada i movem el camió.
    }

    public Route(Store origin, Store destination) throws Exception {
        List<Store> auxiliarList = Arrays.asList(origin.getAllStops(destination));
        this.listStore = new LinkedList<>(auxiliarList) ;

        this.origin = origin.convertStringToInt(destination.getActualLocation());
        this.destination = destination.convertStringToInt(origin.getActualLocation());

        this.timeRoute = calculateTimeRoute(); //metode que retorni temps
        this.kmRoute = calculateTimeRoute(); //metode que retorni els km totals
        this.priceLoadingUnloading = calculatePriceCID(); //metode que calculi el preu CID
        //Generar totes les parades, recorre cada parada i movem el camió.
    }

    public String getId() {
        return id;
    }
    public LinkedList<Store> getListStore() {
        return listStore;
    }
    public int getTimeRoute() {
        return timeRoute;
    }
    public int getKmRoute() {
        return kmRoute;
    }
    public int getPriceLoadingUnloading() {
        return priceLoadingUnloading;
    }
    public Truck getTruck() {
        return truck;
    }
    public int getOrigin() {
        return origin;
    }
    public int getDestination() {
        return destination;
    }
    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public int calculateTimeRoute() throws Exception {
        if(this.origin.equals(destination)) throw new Exception("Same stop.");
        return (listStore.size() * 5 + kmRoute / 100); //quantitat de parades * 5h que esta a cada parada + els km totals de la ruta entre 100
    }

    private int calculateDriverPrice() {

        this.truck.setDrivingTime(this.truck.getKmsTraveled() / ConstantUtilities.VELOCITY);
        int time = this.truck.getDrivingTime();

        int howManyStops = listStore.size()-2;
        if (howManyStops > 0) {
            time = time + ((howManyStops)* ConstantUtilities.WAITING_PERIOD);
            truck.setDrivingTime(time);
        }
        return (int) (time * ConstantUtilities.DRIVER_PRICE_PER_HOUR);

    }
    public int calculatePriceCID() {
        return (listStore.size() * 1000 - 1000); //quantitat de parades * 1000 (preu de la parada) - 1000 (orígen i destí són 500)
    }

    public void moveTruck() throws Exception {
        for (Store store : listStore) {
            truck.makeRoute(store.getDistanceBetweenLocations().get(store.getActualLocation()));
        }
    }
}

