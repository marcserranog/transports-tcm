package com.transports.project.domain;

import java.util.List;

public class Route {
    private int id;
    private Store[] listStore = new Store[5];
    private int timeRoute;
    private int kmRoute;
    private int priceLoadingUnloading;
    private Truck truck;


    public Route(int id, Store initialStore, Store finalStore, Truck truck) throws Exception {
        this.id = id;
        this.listStore = initialStore.getAllStops(finalStore);
        this.timeRoute = calculateTimeRoute(); //metode que retorni temps
        this.kmRoute = calculateTimeRoute(); //metode que retorni els km totals
        this.priceLoadingUnloading = calculatePriceCID(); //metode que calculi el preu CID

    }

    public int getId() {
        return id;
    }

    public Store[] getListStore() {
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


    public int calculateTimeRoute() {
        return (listStore.size() * 5 + kmRoute / 100); //quantitat de parades * 5h que esta a cada parada + els km totals de la ruta entre 100
    }

    public int calculateKmRoute() {
        return 0;    //TODO falta implementar
    }

    public int calculatePriceCID() {
        return (listStore.size() * 1000 - 1000); //quantitat de parades * 1000 (preu de la parada) - 1000 (orígen i destí són 500)
    }

    public void moveTruck() throws Exception {
        for (Store store : listStore) {
            truck.makeRoute(store.getDistance().get(store.getActualLocation()));
        }
    }
}



    /*
    public Route(int id, Store initialStore, Store finalStore, Truck truck) throws Exception {
        this.id = id;
        if(isDirect(initialStore.getActualLocation(),finalStore.getActualLocation(),truck)){
            listStore.addFirst(initialStore);
            listStore.addLast(finalStore);
        }
        else{
            isIndirectWithStops(initialStore.getActualLocation(),finalStore.getActualLocation());
        }
        this.timeRoute = 0;
        this.kmRoute = 0;
    }

    public int getId() {
        return id;
    }
    public List<Store> getListStore() {
        return listStore;
    }
    public int getTimeRoute() {
        return timeRoute;
    }
    public int getKmRoute() {
        return kmRoute;
    }
    public void finalTimeRoute() {
        timeRoute = listStore.size() * 5;
    }
    public int getPriceLoadingUnloading(){ return priceLoadingUnloading;}
    public Truck getTruck() {
        return truck;
    }

    public boolean isDirect(String origin, String end, Truck truck) throws Exception {
        if (origin == end) throw new Exception("Same Store.");
        Store store = new Store(origin);
        if(store.getDistance().get(end) <= ConstantUtilities.MAXIM_KMS){
            this.truck = new Truck(truck.getCapacity());
            return true;
        }
        return false;
    }

    public boolean oneRoute(int k, boolean []m) {
        boolean trobat = false;
        boolean[] marcats = new boolean [5];
        int [][] taulaDistancies = new int [5][5];
        for(int i = 0;i<5 && !trobat;i++){
            if (!marcats[i] && isAcceptable (taulaDistancies[k][i])) {
                sol[j] = i;
                marcats[i] = true;
                if (isFinalRoute(sol,fi)) {
                    for(int c= 0; c<sol.length; c++) {
                        solAmbStores.add(createFinalRoute(sol[c]));
                        c++;
                    }
                    trobat = true;
                } k=i;
                trobat = oneRoute(k, marcats);

            }
            if (!trobat) {marcats[i] = false;}
        }
        return trobat;

    }

    private boolean isAcceptable(int distance) {
        if (distance <= ConstantUtilities.MAXIM_KMS && distance != 0) {
            return true;
        }return false;
    }

    private boolean isFinalRoute (int[] sol, int fi) {
        if (sol[sol.length] == fi){return true;} return false;
    }

    private Store createFinalRoute (int oneStore) {
        Store finalStore;
        switch (oneStore) {
            case 0: finalStore = new Store ("Barcelona"); break;
            case 1: finalStore = new Store ("Vigo"); break;
            case 2: finalStore = new Store ("Sevilla"); break;
            case 3: finalStore = new Store ("Valencia"); break;
            default: finalStore = new Store ("Madrid"); break;
        }
        return finalStore;
    }

    public void moveTruck() throws Exception {
        for(Store store: listStore){
               truck.makeRoute(store.getDistance().get(store.getActualLocation()));
            }
    }


    //TODO >> no fa falta origin i end son int quant a store  utilitzem Strings.

    /*TODO >> falta el tema dels costos, estan las variables pero no estan inicialitzades.
              En el truck estan per ferho, a truck tenim el finalpriceDriver i finalpriceGas
              els haviem d'haver cridat a Route per calcular el preu.*/

    /*TODO >> falta el cas de quan te parades i es indirecta,
           haviem d'haver duplicat el listStore i el Store */

