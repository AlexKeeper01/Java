package com.example.demo.controller;
import com.example.demo.model.Feedback;
import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    private User registeredUser;
    private boolean isAuthenticated = false;

    @GetMapping("/")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password, Model model) {
        if (username.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "Имя пользователя и пароль не должны быть пустыми!");
            return "register";
        }
        registeredUser = new User(username, password);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password, Model model) {
        if (registeredUser == null ||
                !registeredUser.getUsername().equals(username) ||
                !registeredUser.getPassword().equals(password)) {
            model.addAttribute("error", "Неверное имя пользователя или пароль!");
            return "login";
        }
        isAuthenticated = true;
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        if (!isAuthenticated) {
            return "redirect:/login";
        }
        model.addAttribute("username", registeredUser.getUsername());
        model.addAttribute("feedback", new Feedback());
        return "home";
    }

    @PostMapping("/feedback")
    public String handleFeedback(@ModelAttribute Feedback feedback, Model model) {
        System.out.println("Получено сообщение: " + feedback.getMessage() + "\nИмя пользователя: " + registeredUser.getUsername());
        model.addAttribute("username", registeredUser.getUsername());
        model.addAttribute("successMessage", "Ваше сообщение успешно отправлено!");
        return "home";
    }
}
