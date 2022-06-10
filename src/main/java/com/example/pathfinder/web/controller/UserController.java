package com.example.pathfinder.web.controller;

import com.example.pathfinder.model.dto.LoginUserDto;
import com.example.pathfinder.model.dto.RegisterUserDto;
import com.example.pathfinder.service.UserService;
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

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        if (!model.containsAttribute("userInput")) {
            model.addAttribute("userInput", new RegisterUserDto());
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerForm(@Valid RegisterUserDto registerUserDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
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
    public String loginForm(LoginUserDto loginUserDto) {
        userService.login(loginUserDto);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout() {
        userService.logout();

        return "redirect:/";
    }
}
