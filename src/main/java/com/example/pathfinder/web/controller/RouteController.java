package com.example.pathfinder.web.controller;

import com.example.pathfinder.model.view.RouteDetailsViewModel;
import com.example.pathfinder.model.view.RouteViewModel;
import com.example.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public String allRoutesView(Model model) {
        List<RouteViewModel> routeViewModels = routeService.getAllRoutes();
        model.addAttribute("routes", routeViewModels);

        return "routes";
    }

    @GetMapping("/details/{id}")
    public String routeDetailsView(@PathVariable(name = "id") Long id, Model model) {
        RouteDetailsViewModel routeDetailsViewModel = routeService.getRouteDetails(id);
        model.addAttribute("route", routeDetailsViewModel);

        return "route-details";
    }

    @GetMapping("/pedestrian")
    public String pedestrianRoutesView(Model model) {
        List<RouteViewModel> routeViewModels = routeService.getPedestrianRoutes();
        model.addAttribute("routes", routeViewModels);
        model.addAttribute("title", "Pedestrian routes");

        return "routes-category";
    }

    @GetMapping("/bicycle")
    public String bicycleRoutesView(Model model) {
        List<RouteViewModel> routeViewModels = routeService.getBicycleRoutes();
        model.addAttribute("routes", routeViewModels);
        model.addAttribute("title", "Bicycle routes");

        return "routes-category";
    }

    @GetMapping("/motorcycle")
    public String motorcycleRoutesView(Model model) {
        List<RouteViewModel> routeViewModels = routeService.getMotorcycleRoutes();
        model.addAttribute("routes", routeViewModels);
        model.addAttribute("title", "Motorcycle routes");

        return "routes-category";
    }

    @GetMapping("/car")
    public String carRoutesView(Model model) {
        List<RouteViewModel> routeViewModels = routeService.getCarRoutes();
        model.addAttribute("routes", routeViewModels);
        model.addAttribute("title", "Car routes");

        return "routes-category";
    }
}
