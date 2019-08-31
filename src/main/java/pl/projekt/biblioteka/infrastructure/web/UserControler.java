package pl.projekt.biblioteka.infrastructure.web;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.projekt.biblioteka.domain.UserFinder;
import pl.projekt.biblioteka.domain.UserService;
import pl.projekt.biblioteka.infrastructure.dto.UserDto;
import pl.projekt.biblioteka.infrastructure.entity.User;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserControler {
    private final UserFinder userFinder;
    private final UserService userService;


    @GetMapping("/create")
    ModelAndView createUserView() {
        ModelAndView modelAndView = new ModelAndView("createUser.html");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }

    @PostMapping("/create")
    String createUser(@ModelAttribute UserDto user) {
        userService.createOrUpdate(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/";
    }

    //@PreAuthorize("hasRole('USER')")

    @GetMapping("/edit")
    ModelAndView editUser(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("createUser.html");
        modelAndView.addObject("user", userFinder.findById(id));
        return modelAndView;
    }

    @GetMapping("/getall")
    ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView("allUsers.html");
        modelAndView.addObject("user", userService.findAllUsers());
        return modelAndView;
    }
}
