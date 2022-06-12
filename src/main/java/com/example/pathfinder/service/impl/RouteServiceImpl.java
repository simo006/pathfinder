package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Picture;
import com.example.pathfinder.model.entity.Route;
import com.example.pathfinder.model.view.PictureViewModel;
import com.example.pathfinder.model.view.RouteDetailsViewModel;
import com.example.pathfinder.model.view.RouteViewModel;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

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

    @Override
    public RouteDetailsViewModel getRouteDetails(Long id) {
        Route route = routeRepository.findById(id).orElseThrow();
        List<PictureViewModel> pictures = route.getPictures().stream()
                .map(picture -> modelMapper.map(picture, PictureViewModel.class))
                .toList();

        RouteDetailsViewModel routeDetailsViewModel = modelMapper.map(route, RouteDetailsViewModel.class);
        routeDetailsViewModel.setAuthorName(route.getAuthor().getFullName());
        routeDetailsViewModel.setPictures(pictures);

        return routeDetailsViewModel;
    }

    private RouteViewModel mapRouteViewModel(Route route) {
        RouteViewModel routeViewModel = modelMapper.map(route, RouteViewModel.class);

        Picture first = route.getPictures().stream().findFirst().orElseThrow();
        PictureViewModel picture = modelMapper.map(first, PictureViewModel.class);
        routeViewModel.setPicture(picture);

        return routeViewModel;
    }
}
