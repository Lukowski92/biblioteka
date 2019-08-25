package pl.projekt.biblioteka.infrastructure.web;

import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.projekt.biblioteka.domain.BookFinder;
import pl.projekt.biblioteka.domain.BookService;
import pl.projekt.biblioteka.infrastructure.entity.Book;
import pl.projekt.biblioteka.infrastructure.type.Cathegory;
import pl.projekt.biblioteka.infrastructure.dto.BookDto;
import pl.projekt.biblioteka.infrastructure.dto.CathegoryDto;

import java.util.Arrays;
import java.util.List;
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
        modelAndView.addObject("book", bookFinder.findByCathegory(cathegory));
        return modelAndView;
    }

    @GetMapping("/create")
    ModelAndView createBookView() {
        ModelAndView modelAndView = new ModelAndView("createBook.html");
        modelAndView.addObject("book", new BookDto());
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

    @GetMapping("/delete")
    String deleteDoctor(@RequestParam Long id) {
        bookService.delete(id);
        return "redirect:/";
    }

    @PreAuthorize("hasRole('USER')")
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
