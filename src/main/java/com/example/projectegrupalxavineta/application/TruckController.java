package com.example.projectegrupalxavineta.application;

import com.example.projectegrupalxavineta.application.dtos.RouteDTO;
import com.example.projectegrupalxavineta.application.dtos.TruckDTO;
import com.example.projectegrupalxavineta.domain.Route;
import com.example.projectegrupalxavineta.domain.Truck;
import com.example.projectegrupalxavineta.persistance.RouteDAO;
import com.example.projectegrupalxavineta.persistance.TruckDAO;
import com.example.projectegrupalxavineta.persistance.TruckRepository;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;

@Controller
public class TruckController {
    private TruckRepository truckRepository;

    public TruckController(){}
    public TruckController(TruckRepository truckRepository){
        this.truckRepository=truckRepository;
    }

    public TruckDTO createTruck(TruckDTO truckDTO) throws Exception {
        Truck truck = new Truck(truckDTO);
        new TruckDAO().addTruck(truck);
        return new TruckDTO(truck);
    }
    public TruckDTO createTruckInRoute(TruckDTO truckDTO, String routeId) throws Exception {
        Truck truck = new Truck(truckDTO);
        Route route = new RouteDAO().findRouteById(routeId);
        route.setTruck(truck);
        new TruckDAO().addTruck(truck);
        return new TruckDTO(truck);
    }

    public List<TruckDTO> getAllTrucks() {
        List<Truck> trucks = new TruckDAO().getTrucks();
        return truckToTruckDTO(trucks);
    }

    private List<TruckDTO> truckToTruckDTO(List<Truck> trucks) {
        List<TruckDTO> auxiliaryList = new List<>();
        for (Truck truck : trucks) {
            auxiliaryList.add(new TruckDTO(truck));
        }
        return auxiliaryList;
    }
    public void deleteTruckById(String id) {
        new TruckDAO().deleteTruck(id);
    }
}
