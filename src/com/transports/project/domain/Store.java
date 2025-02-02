package com.transports.project.domain;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private String actualLocation;
    private int[][] distanceBetweenLocations = {{0, 1200, 800, 400, 700}, {1200, 0, 600, 800, 500},
            {800, 600, 0, 400, 500}, {400, 800, 400, 0, 300}, {700, 500, 500, 300, 0}};
    private HashMap<String, Integer> distance = new HashMap<String, Integer>();

    private Map<String, Integer> distanceFromBarcelona() {
        distance.put("Barcelona", 0);
        distance.put("Vigo", 1200);
        distance.put("Sevilla", 800);
        distance.put("Valencia", 400);
        distance.put("Madrid", 700);
        return distance;
    }

    private Map<String, Integer> distanceFromMadrid() {
        distance.put("Barcelona", 700);
        distance.put("Vigo", 500);
        distance.put("Sevilla", 500);
        distance.put("Valencia", 300);
        distance.put("Madrid", 0);
        return distance;
    }

    private Map<String, Integer> distanceFromValencia() {
        distance.put("Barcelona", 400);
        distance.put("Vigo", 800);
        distance.put("Sevilla", 400);
        distance.put("Valencia", 0);
        distance.put("Madrid", 300);
        return distance;
    }

    private Map<String, Integer> distanceFromSevilla() {
        distance.put("Barcelona", 800);
        distance.put("Vigo", 600);
        distance.put("Sevilla", 0);
        distance.put("Valencia", 400);
        distance.put("Madrid", 500);
        return distance;
    }

    private Map<String, Integer> distanceFromVigo() {
        distance.put("Barcelona", 1200);
        distance.put("Vigo", 0);
        distance.put("Sevilla", 600);
        distance.put("Valencia", 800);
        distance.put("Madrid", 500);
        return distance;
    }

    private int[] solution;
    private int finalStore;

    public Store(String actualLocation) {
        switch (actualLocation) {
            case "Barcelona":
                this.distance = (HashMap<String, Integer>) distanceFromBarcelona();
                break;
            case "Madrid":
                this.distance = (HashMap<String, Integer>) distanceFromMadrid();
                break;
            case "Valencia":
                this.distance = (HashMap<String, Integer>) distanceFromValencia();
                break;
            case "Sevilla":
                this.distance = (HashMap<String, Integer>) distanceFromSevilla();
                break;
            case "Vigo":
                this.distance = (HashMap<String, Integer>) distanceFromVigo();
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

    public HashMap<String, Integer> getDistance() {
        return distance;
    }

    public int[][] getDistanceBetweenLocations() {
        return distanceBetweenLocations;
    }


    //funcion para passar de una store en string a int
    private int convertStringToInt(String storeName) {
        int aux = 100;  //un valor qualsevol per inicialitzar
        switch (storeName) {
            case "Barcelona":
                aux = 0;
                break;
            case "Vigo":
                aux = 1;
                break;
            case "Sevilla":
                aux = 2;
                break;
            case "Valencia":
                aux = 3;
                break;
            case "Madrid":
                aux = 4;
                break;
        }
        return aux;
    }

    public Store[] getAllStops(Store finalStore) {

        int initialStoreInt = convertStringToInt(this.getActualLocation());
        int finalStoreInt = convertStringToInt((String) finalStore.getActualLocation());

        int[][] distanceBetweenLocations = {{0, 1200, 800, 400, 700}, {1200, 0, 600, 800, 500}, {800, 600, 0, 400, 500}, {400, 800, 400, 0, 300}, {700, 500, 500, 300, 0}};

        int solution[] = new int[5];
        solution[0] = initialStoreInt;
        for (int i = 1; i < solution.length; i++) solution[i] = 9;

        Store[] routeWithStores = new Store[5];
        for (int i = 0; i < routeWithStores.length; i++) routeWithStores[i] = null;

        oneRoute(1, solution, distanceBetweenLocations, finalStoreInt);
        return routeWithStores;

    }

    public boolean oneRoute(int levelBackTracking, int[] solution, int[][] distanceBetweenLocations, int finalStore) {
        boolean routeFound = false;

        for (int y = 0; y < distanceBetweenLocations.length; y++) {
            for (int x = 0; x < distanceBetweenLocations.length; x++) {
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
        return routeFound;
    }

    private boolean routeAcceptable(int row, int column, int levelBackTracking, int[] solution, int[][] distanceBetweenLocations) {

        boolean aux = true;
        boolean out = false;
        int distance = distanceBetweenLocations[column][row];

        if (levelBackTracking < 5) {
            if (column == solution[levelBackTracking - 1]) {
                for (int i = 0; i <= levelBackTracking; i++) if (row == solution[i]) aux = false;
                if (distance <= 667 && distance != 0 && aux) out = true;
            }
        }

        return out;
    }
    /*
        private boolean Repeated(int x,int y,int k){
            boolean out = false;

            if (x == solucio[solucio.length-1] || y == solucio[solucio.length-1]) {
            	out = false;
            }
            */
            /*
            if (solucio[solucio.length-1] == x)
            for(int i = 0; i< solucio.length; i++) {
                if (x == solucio[i]||y== solucio[i]) out = true;
            }
            *//*
            if(k == 4)
                out = true;

            return out;
        }
*/


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













