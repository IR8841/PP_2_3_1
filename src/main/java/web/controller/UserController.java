package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping()
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", service.getAllUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String getUsers(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", service.findUser(id));
        return "/view";
    }

    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String updateUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", service.findUser(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        service.updateUser(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable("id") long id) {
        service.deleteUser(id);
        return "redirect:/";
    }
}