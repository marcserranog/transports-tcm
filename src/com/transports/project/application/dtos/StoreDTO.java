package com.transports.project.application.dtos;

import com.transports.project.domain.Store;

import java.util.HashMap;

public class StoreDTO {
    private HashMap<String, Integer> distance = new HashMap<String, Integer>();

    private String actualLocation;

    public StoreDTO() {
    }

    public StoreDTO(HashMap<String, Integer> distance, String actualLocation) {
        this.distance = distance;
        this.actualLocation = actualLocation;
    }

    public StoreDTO(Store store) throws Exception {
        if (store == null) throw new Exception();
        this.distance = store.getDistance();
        this.actualLocation = store.getActualLocation();
    }

    public HashMap<String, Integer> getDistance() {
        return distance;
    }
    public String getActualLocation() {
        return actualLocation;
    }
}
