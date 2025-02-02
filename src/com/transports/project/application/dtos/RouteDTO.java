package com.transports.project.application.dtos;

import com.transports.project.domain.Route;

public class RouteDTO {
    private int distance;
    private int kmRoute;
    private int timeRoute;
    private int priceLoadingUnloading;


    public RouteDTO() {
    }
    public RouteDTO(Route route) throws Exception {
        if(route==null) throw new Exception();
        this.kmRoute=route.getKmRoute();
        this.timeRoute=route.getTimeRoute();
        this.priceLoadingUnloading=route.getPriceLoadingUnloading();
    }
    public RouteDTO(int distance, int kmRoute, int timeRoute, int priceLoadingUnloading) {
        this.distance = distance;
        this.kmRoute = kmRoute;
        this.timeRoute = timeRoute;
        this.priceLoadingUnloading = priceLoadingUnloading;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getKmRoute() {
        return kmRoute;
    }

    public void setKmRoute(int kmRoute) {
        this.kmRoute = kmRoute;
    }

    public int getTimeRoute() {
        return timeRoute;
    }

    public void setTimeRoute(int timeRoute) {
        this.timeRoute = timeRoute;
    }

    public int getPriceLoadingUnloading() {
        return priceLoadingUnloading;
    }

    public void setPriceLoadingUnloading(int priceLoadingUnloading) {
        this.priceLoadingUnloading = priceLoadingUnloading;
    }
}
