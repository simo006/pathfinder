package com.example.pathfinder.web.controller;

import com.example.pathfinder.model.dto.AddModelDto;
import com.example.pathfinder.model.enums.CategoryEnum;
import com.example.pathfinder.model.enums.LevelEnum;
import com.example.pathfinder.model.view.RouteDetailsViewModel;
import com.example.pathfinder.model.view.RouteViewModel;
import com.example.pathfinder.service.RouteService;
import com.example.pathfinder.user.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final CurrentUser currentUser;

    public RouteController(RouteService routeService, CurrentUser currentUser) {
        this.routeService = routeService;
        this.currentUser = currentUser;
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

    @GetMapping("/add")
    public String addRouteView(Model model) {
        if (!currentUser.isLogged()) {
            return "redirect:/";
        }

        if (!model.containsAttribute("routeData")) {
            model.addAttribute("routeData", new AddModelDto());
        }

        model.addAttribute("levels", LevelEnum.values());
        model.addAttribute("categories", CategoryEnum.values());

        return "add-route";
    }

    @PostMapping("/add")
    public String addRouteForm(@ModelAttribute("routeData") @Valid AddModelDto addModelDto,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.routeData", bindingResult);
            redirectAttributes.addFlashAttribute("routeData", addModelDto);

            return "redirect:/routes/add";
        }

        routeService.addRoute(addModelDto);

        return "redirect:/routes";
    }
}
