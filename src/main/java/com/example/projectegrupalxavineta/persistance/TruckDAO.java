package com.example.projectegrupalxavineta.persistance;

import com.example.projectegrupalxavineta.domain.Route;
import com.example.projectegrupalxavineta.domain.Truck;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TruckDAO {
    private static List<Truck> trucks = new ArrayList<>();

    public Truck findTruckById(String id) throws Exception {
        for (Truck truck : trucks ) {
            if (truck.getId().equals(id))
                return truck;
        }
        throw new Exception("No Truck finded");
    }

    public void addTruck(Truck truck) {
        trucks.add(truck);
    }

    public void deleteTruck(String id) {
        for (Truck truck : new ArrayList<>(trucks)) {
            if (truck.getId().equals(id))
                trucks.remove(truck);
        }
    }
    public List<Truck> getTrucks() {
        return trucks;
    }

    public void deleteAll() {
        trucks = new ArrayList<>();
    }
}
