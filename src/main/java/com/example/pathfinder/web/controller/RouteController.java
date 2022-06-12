package com.example.pathfinder.web.controller;

import com.example.pathfinder.model.view.RouteViewModel;
import com.example.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
