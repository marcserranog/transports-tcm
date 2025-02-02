package com.example.projectegrupalxavineta.application;

import com.example.projectegrupalxavineta.application.dtos.RouteDTO;
import com.example.projectegrupalxavineta.application.dtos.TruckDTO;
import com.example.projectegrupalxavineta.domain.Route;
import com.example.projectegrupalxavineta.domain.Store;
import com.example.projectegrupalxavineta.domain.Truck;
import com.example.projectegrupalxavineta.persistance.RouteDAO;
import com.example.projectegrupalxavineta.persistance.RouteRepository;
import com.example.projectegrupalxavineta.persistance.TruckDAO;
import com.example.projectegrupalxavineta.persistance.TruckRepository;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;

@Controller
public class RouteController {

    private RouteRepository routeRepository;
    private TruckRepository truckRepository;

    public RouteController() {
    }

    public RouteController(RouteRepository routeRepository, TruckRepository truckRepository) {
        this.routeRepository = routeRepository;
        this.truckRepository = truckRepository;
    }
    public RouteDTO createRoute(String initialStore, String finalStore, TruckDTO truckDTO) throws Exception {
        Store origin = new Store(initialStore);
        Store destiny = new Store(finalStore);

        Truck truck = new Truck(truckDTO);
        truckRepository.save(truck);

        Route route = new Route(origin,destiny,truck);
        routeRepository.save(route);

        return new RouteDTO(route);
    }
    public RouteDTO createRoute(String initialStore, String finalStore) throws Exception {
        Store origin = new Store(initialStore);
        Store destiny = new Store(finalStore);

        Route route = new Route(origin,destiny);
        routeRepository.save(route);

        return new RouteDTO(route);
    }

    public LinkedList<RouteDTO> getAllRoutes() throws Exception {
        LinkedList<Route> routes=new RouteDAO().getRoutes();
        return routeToRouteDTO(routes);
    }

    private LinkedList<RouteDTO> routeToRouteDTO(LinkedList<Route> routes) throws Exception {
        LinkedList<RouteDTO> auxiliaryList = new LinkedList<>();
        for (Route route : routes) {
            auxiliaryList.add(new RouteDTO(route));
        }
        return auxiliaryList;

    }

    public void deleteAllRoutes() {
        new RouteDAO().deleteAll();
        new TruckDAO().deleteAll();
    }

    public RouteDTO getRouteById(String id) throws Exception {
        Route route= new RouteDAO().findRouteById(id);
        return new RouteDTO(route);
    }

    public void deleteRouteById(String id) {
        new RouteDAO().deleteRoute(id);
    }



//TODO IMPORTANT, hauria de tenir un createroute in tinc un initial un final i un truck dto  es crea la ruta amb el truck

}
