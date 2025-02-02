package com.example.projectegrupalxavineta.domain;


import com.example.projectegrupalxavineta.utilities.ConstantUtilities;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.example.projectegrupalxavineta.utilities.ConstantUtilities.*;

public class Store {
    private String actualLocation;
    private HashMap<Integer, Integer> distanceBetweenLocations = new HashMap<Integer, Integer>();

    private Map<Integer, Integer> distanceFromBarcelona() {
        distanceBetweenLocations.put(BARCELONA, 0);
        distanceBetweenLocations.put(VIGO, 1200);
        distanceBetweenLocations.put(SEVILLA, 800);
        distanceBetweenLocations.put(VALENCIA, 400);
        distanceBetweenLocations.put(MADRID, 700);
        return distanceBetweenLocations;
    }
    private Map<Integer, Integer> distanceFromVigo() {
        distanceBetweenLocations.put(BARCELONA, 1200);
        distanceBetweenLocations.put(VIGO, 0);
        distanceBetweenLocations.put(SEVILLA, 600);
        distanceBetweenLocations.put(VALENCIA, 800);
        distanceBetweenLocations.put(MADRID, 500);
        return distanceBetweenLocations;
    }
    private Map<Integer, Integer> distanceFromSevilla() {
        distanceBetweenLocations.put(BARCELONA, 800);
        distanceBetweenLocations.put(VIGO, 600);
        distanceBetweenLocations.put(SEVILLA, 0);
        distanceBetweenLocations.put(VALENCIA, 400);
        distanceBetweenLocations.put(MADRID, 500);
        return distanceBetweenLocations;
    }
    private Map<Integer, Integer> distanceFromValencia() {
        distanceBetweenLocations.put(BARCELONA, 400);
        distanceBetweenLocations.put(VIGO, 800);
        distanceBetweenLocations.put(SEVILLA, 400);
        distanceBetweenLocations.put(VALENCIA, 0);
        distanceBetweenLocations.put(MADRID, 300);
        return distanceBetweenLocations;
    }
    private Map<Integer, Integer> distanceFromMadrid() {
        distanceBetweenLocations.put(BARCELONA, 700);
        distanceBetweenLocations.put(VIGO, 500);
        distanceBetweenLocations.put(SEVILLA, 500);
        distanceBetweenLocations.put(VALENCIA, 300);
        distanceBetweenLocations.put(MADRID, 0);
        return distanceBetweenLocations;
    }


    public Store(String actualLocation) {
        switch (actualLocation) {
            case "Barcelona":
                this.distanceBetweenLocations = (HashMap<Integer, Integer>) distanceFromBarcelona();
                break;
            case "Vigo":
                this.distanceBetweenLocations = (HashMap<Integer, Integer>) distanceFromVigo();
                break;
            case "Sevilla":
                this.distanceBetweenLocations = (HashMap<Integer, Integer>) distanceFromSevilla();
                break;
            case "Valencia":
                this.distanceBetweenLocations = (HashMap<Integer, Integer>) distanceFromValencia();
                break;
            case "Madrid":
                this.distanceBetweenLocations = (HashMap<Integer, Integer>) distanceFromMadrid();
                break;
        }
        this.actualLocation = actualLocation;
    }

    public String getActualLocation() {
        return actualLocation;
    }
    public void setActualLocation(String actualLocation) {
        this.actualLocation = actualLocation;
    }
    public HashMap<Integer, Integer> getDistanceBetweenLocations() {
        return distanceBetweenLocations;
    }

    //funcion para passar de una store en string a int
    public static int convertStringToInt(String storeName) {
        int auxiliaryVariable = 100;  //un valor qualsevol per inicialitzar
        switch (storeName) {
            case "Barcelona":
                auxiliaryVariable = 0;
                break;
            case "Vigo":
                auxiliaryVariable = 1;
                break;
            case "Sevilla":
                auxiliaryVariable = 2;
                break;
            case "Valencia":
                auxiliaryVariable = 3;
                break;
            case "Madrid":
                auxiliaryVariable = 4;
                break;
        }
        return auxiliaryVariable;
    }

    public Store[] getAllStops(Store finalStore) {

        int initialStoreInt = convertStringToInt(this.getActualLocation());
        int finalStoreInt = convertStringToInt(finalStore.getActualLocation());

        Set<Integer> distanceBetweenLocations = getDistanceBetweenLocations().keySet();

        int solution[] = new int[5];
        solution[0] = initialStoreInt;
        for (int i = 1; i < solution.length; i++) solution[i] = 9;

        Store[] routeWithStores = new Store[5];
        for (int i = 0; i < routeWithStores.length; i++) routeWithStores[i] = null;

        oneRoute(1, solution, distanceBetweenLocations, finalStoreInt);
        return routeWithStores;

    }

    public boolean oneRoute(int levelBackTracking, int[] solution, Set<Integer> distanceBetweenLocations, int finalStore) {

        for (int y = 0; y < distanceBetweenLocations.size(); y++) {
            for (int x = 0; x < distanceBetweenLocations.size(); x++) {
                if (routeAcceptable(x, y, levelBackTracking, solution, distanceBetweenLocations)) {
                    solution[levelBackTracking] = x;
                    if (isFinalRoute(levelBackTracking, solution, finalStore)) {
                        System.out.println("done");
                        break;
                    } else {
                        oneRoute(levelBackTracking + 1, solution, distanceBetweenLocations, finalStore);
                    }
                }
            }
        }
        return false;
    }

    private boolean routeAcceptable(int row, int column, int levelBackTracking, int[] solution, Set<Integer> distanceBetweenLocations) {

        boolean aux = true;
        boolean out = false;

        int [][] stores = (int[][]) distanceBetweenLocations.toArray();
        int distance = stores[column][row];

        if (levelBackTracking < distanceBetweenLocations.size()) {
            if (column == solution[levelBackTracking - 1]) {
                for (int i = 0; i <= levelBackTracking; i++) if (row == solution[i]) aux = false;
                if (distance <= ConstantUtilities.MAXIM_KMS  && distance != 0 && aux) out = true;
            }
        }

        return out;
    }


    private boolean isFinalRoute(int levelBackTracking, int[] solution, int finalStore) {
        boolean out = false;
        if (solution[levelBackTracking] == finalStore) {
            out = true;
        }
        return out;
    }

    /*private void printSolution() {
        for (int i=0; i<solucio.length;i++) {
            if(solucio[i]!=9) System.out.print("/"+solucio[i]+"/");
        }
    }
    */


    private Store[] createFinalRoute(int[] solution, int levelBackTracking) {
        Store finalStore = null;
        Store[] finalStoresRoute = new Store[5];
        for (int i = 0; i < levelBackTracking + 1; i++) {
            switch (solution[i]) {
                case 0:
                    finalStore = new Store("Barcelona");
                    break;
                case 1:
                    finalStore = new Store("Vigo");
                    break;
                case 2:
                    finalStore = new Store("Sevilla");
                    break;
                case 3:
                    finalStore = new Store("Valencia");
                    break;
                case 4:
                    finalStore = new Store("Madrid");
                    break;
            }
            finalStoresRoute[i] = finalStore;
        }
        return finalStoresRoute;
    }


}













