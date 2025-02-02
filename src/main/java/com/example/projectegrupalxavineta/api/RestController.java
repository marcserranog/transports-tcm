package com.example.projectegrupalxavineta.api;

import com.example.projectegrupalxavineta.application.RouteController;
import com.example.projectegrupalxavineta.application.TruckController;
import com.example.projectegrupalxavineta.application.dtos.RouteDTO;
import com.example.projectegrupalxavineta.application.dtos.TruckDTO;
import com.example.projectegrupalxavineta.domain.Route;
import com.example.projectegrupalxavineta.persistance.RouteDAO;
import com.example.projectegrupalxavineta.persistance.TruckDAO;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @PostMapping("/routes")
    public RouteDTO createRoute(@RequestBody RouteDTO routeDTO) throws Exception {
        return new RouteController().createRoute(routeDTO.getOrigin(),routeDTO.getDestination());
    }
    @GetMapping("/routes")
    public LinkedList<RouteDTO> getAllRoutes () throws Exception {
        return new RouteController().getAllRoutes();
    }
    @DeleteMapping("/routes")
    public void deleteAllroutes() {
        new RouteController().deleteAllRoutes();
    }

    @GetMapping("/routes/{id}")
    public RouteDTO getRouteById(@PathVariable String id) throws Exception {
        return new RouteController().getRouteById(id);
    }
    @DeleteMapping("/routes/{id}")
    public void deleteRouteById(@PathVariable String id){
         new RouteController().deleteRouteById(id);
    }
    @PostMapping("/trucks")
    public TruckDTO createTruck(@RequestBody TruckDTO truckDTO) throws Exception {
        return new TruckController().createTruck(truckDTO);
    }
    @GetMapping("/trucks")
    public List<TruckDTO> getAllTrucks () throws Exception {
        return new TruckController().getAllTrucks();
    }
    @DeleteMapping("/truck/{id}")
    public void deleteTruckById(@PathVariable String id){
        new TruckController().deleteTruckById(id);
    }
    @PostMapping("/routes/{id}/trucks")
    public TruckDTO createTruckInRoute(@RequestBody TruckDTO truckDTO,@PathVariable String id) throws Exception {
        return new TruckController().createTruckInRoute(truckDTO,id);
    }
    @GetMapping("/routes/{id}/trucks")
    public TruckDTO getTruckByIdInRoute(@PathVariable String id) throws Exception {
        Route route = new RouteDAO().findRouteById(id);
        return new TruckDTO(route.getTruck());
    }
    @DeleteMapping("/routes/{id}/trucks")
    public void deleteTruckByIdInRoute(@PathVariable String id) throws Exception {
        new TruckController().deleteTruckById(id);
    }


}
