package com.example.pathfinder.service;

import com.example.pathfinder.model.view.RouteDetailsViewModel;
import com.example.pathfinder.model.view.RouteViewModel;

import java.util.List;

public interface RouteService {

    List<RouteViewModel> getAllRoutes();

    RouteDetailsViewModel getRouteDetails(Long id);

    List<RouteViewModel> getPedestrianRoutes();

    List<RouteViewModel> getBicycleRoutes();

    List<RouteViewModel> getMotorcycleRoutes();

    List<RouteViewModel> getCarRoutes();
}
