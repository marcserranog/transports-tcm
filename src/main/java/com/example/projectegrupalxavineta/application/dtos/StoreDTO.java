package com.example.projectegrupalxavineta.application.dtos;

import com.example.projectegrupalxavineta.domain.Store;

import java.util.HashMap;

public class StoreDTO {

    private String actualLocation;

    public StoreDTO() {
    }

    public StoreDTO(HashMap<Integer, Integer> distance, String actualLocation) {
        this.actualLocation = actualLocation;
    }

    public StoreDTO(Store store) throws Exception {
        if (store == null) throw new Exception();
        this.actualLocation = store.getActualLocation();
    }

    public String getActualLocation() {
        return actualLocation;
    }
}
