package com.example.projectegrupalxavineta.persistance;

import com.example.projectegrupalxavineta.domain.Route;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RouteDAO {
    private static LinkedList<Route> routes = new LinkedList<>();

    public void addRoute(Route route) {
        routes.add(route);
    }


    public Route findRouteById(String id) throws Exception {
        for (Route route : routes ) {
            if (route.getId().equals(id))
                return route;

        }
        throw new Exception("No Route finded");
    }

    public LinkedList<Route> getRoutes() {
        return routes;
    }

    public void deleteRoute(String id) {
        for (Route route : new LinkedList<>(routes)) {
            if (route.getId().equals(id))
                routes.remove(route);

        }
    }
    public void deleteAll() {
        routes = new LinkedList<>();
    }


}
