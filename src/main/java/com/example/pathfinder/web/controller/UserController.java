package com.example.pathfinder.web.controller;

import com.example.pathfinder.model.dto.LoginUserDto;
import com.example.pathfinder.model.dto.RegisterUserDto;
import com.example.pathfinder.service.UserService;
import com.example.pathfinder.user.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final CurrentUser currentUser;

    public UserController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        if (!model.containsAttribute("userInput")) {
            model.addAttribute("userInput", new RegisterUserDto());
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerForm(@ModelAttribute("userInput") @Valid RegisterUserDto registerUserDto,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userInput", bindingResult);
            redirectAttributes.addFlashAttribute("userInput", registerUserDto);

            return "redirect:/users/register";
        }

        userService.register(registerUserDto);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }

    @PostMapping("/login")
    public String loginForm(LoginUserDto loginUserDto, RedirectAttributes redirectAttributes) {
        if (!userService.login(loginUserDto)) {
            redirectAttributes.addFlashAttribute("noUserFound", "No user with the given username and password was found!");

            return "redirect:/users/login";
        }

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout() {
        userService.logout();

        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profileView() {
        if (!currentUser.isLogged()) {
            return "redirect:/";
        }

        return "profile";
    }
}
