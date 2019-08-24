package pl.projekt.biblioteka.infrastructure.web;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.projekt.biblioteka.domain.BookFinder;
import pl.projekt.biblioteka.domain.BookService;
import pl.projekt.biblioteka.infrastructure.dto.UserDto;
import pl.projekt.biblioteka.infrastructure.entity.Book;
import pl.projekt.biblioteka.infrastructure.type.Cathegory;
import pl.projekt.biblioteka.infrastructure.dto.BookDto;
import pl.projekt.biblioteka.infrastructure.dto.CathegoryDto;

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
        ModelAndView modelAndView = new ModelAndView("createBook.html");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }

    @PostMapping("/create")
    String createUser(@ModelAttribute UserDto user) {
        userService.createOrUpdate(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    String deleteDoctor(@RequestParam Long id) {
        bookService.delete(id);
        return "redirect:/";
    }

    // @PreAuthorize("hasRole('USER')")
    @GetMapping("/edit")
    ModelAndView editBook(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("createBook.html");
        modelAndView.addObject("book", bookFinder.findById(id));
        return modelAndView;
    }

    @GetMapping("/getall")
    ModelAndView getAllBook() {
        ModelAndView modelAndView = new ModelAndView("allBooks.html");
        modelAndView.addObject("book", bookService.findAllBooks());
        return modelAndView;
    }
}
