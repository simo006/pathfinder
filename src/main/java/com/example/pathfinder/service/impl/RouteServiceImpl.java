package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Picture;
import com.example.pathfinder.model.entity.Route;
import com.example.pathfinder.model.enums.CategoryEnum;
import com.example.pathfinder.model.view.PictureViewModel;
import com.example.pathfinder.model.view.RouteDetailsViewModel;
import com.example.pathfinder.model.view.RouteViewModel;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public List<RouteViewModel> getPedestrianRoutes() {
        return getRouteByCategoryName(CategoryEnum.PEDESTRIAN);
    }

    @Override
    public List<RouteViewModel> getBicycleRoutes() {
        return getRouteByCategoryName(CategoryEnum.BICYCLE);
    }

    @Override
    public List<RouteViewModel> getMotorcycleRoutes() {
        return getRouteByCategoryName(CategoryEnum.MOTORCYCLE);
    }

    @Override
    public List<RouteViewModel> getCarRoutes() {
        return getRouteByCategoryName(CategoryEnum.CAR);
    }

    private List<RouteViewModel> getRouteByCategoryName(CategoryEnum categoryName) {
        Set<Route> routes = routeRepository.findAllByCategoryNameEquals(categoryName);

        return routes.stream()
                .map(this::mapRouteViewModel)
                .collect(Collectors.toList());
    }

    private RouteViewModel mapRouteViewModel(Route route) {
        RouteViewModel routeViewModel = modelMapper.map(route, RouteViewModel.class);

        Picture first = route.getPictures().stream().findFirst().orElseThrow();
        PictureViewModel picture = modelMapper.map(first, PictureViewModel.class);
        routeViewModel.setPicture(picture);

        return routeViewModel;
    }
}
