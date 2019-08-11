package pl.projekt.biblioteka.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.projekt.biblioteka.Repositories.BookRepository;
import pl.projekt.biblioteka.Services.BookFinder;
import pl.projekt.biblioteka.Services.BookService;
import pl.projekt.biblioteka.Type.Cathegory;
import pl.projekt.biblioteka.dto.BookDto;
import pl.projekt.biblioteka.dto.CathegoryDto;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookControler {
    private final BookFinder bookFinder;
    private final BookService bookService;

    @GetMapping("/get/{cathegory}")
    ModelAndView getBook(@PathVariable String cathegory) {
        ModelAndView modelAndView = new ModelAndView("ksiazki.html");
        modelAndView.addObject("kategoria", cathegory);
        modelAndView.addObject("ksiazka", bookFinder.findByCathegory(cathegory));
        return modelAndView;
    }

    @GetMapping("/create")
    ModelAndView createBookView() {
        ModelAndView modelAndView = new ModelAndView("createDoctor.html");
        modelAndView.addObject("doctor", new BookDto());
        modelAndView.addObject("specializations",
                Arrays.stream(Cathegory.values())
                        .map(spec -> new CathegoryDto(spec, spec.getLabel()))
                        .collect(Collectors.toList()));
        return modelAndView;
    }

    @PostMapping("/create")
    String createBook(@ModelAttribute BookDto book) {
        bookService.createOrUpdate(book);

        return "redirect:/";
    }

}
