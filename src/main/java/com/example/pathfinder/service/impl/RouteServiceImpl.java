package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Route;
import com.example.pathfinder.model.view.RouteViewModel;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class RouteServiceImpl implements RouteService {

    private RouteRepository routeRepository;
    private ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RouteViewModel> getAllRoutes() {
        List<Route> routes = routeRepository.findAll();

        return routes.stream()
                .map(this::mapRouteViewModel)
                .toList();
    }

    private RouteViewModel mapRouteViewModel(Route route) {
        RouteViewModel routeViewModel = modelMapper.map(route, RouteViewModel.class);
        routeViewModel.setImageUrl(route.getPictures().get(0).getUrl());

        return routeViewModel;
    }
}
